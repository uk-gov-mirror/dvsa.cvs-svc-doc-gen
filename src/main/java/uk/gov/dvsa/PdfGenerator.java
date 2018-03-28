package uk.gov.dvsa;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uk.gov.dvsa.exception.HttpException;
import uk.gov.dvsa.logging.EventLogger;
import uk.gov.dvsa.logging.EventType;
import uk.gov.dvsa.model.ApiGatewayResponse;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.service.HtmlGeneratorFactory;
import uk.gov.dvsa.service.PDFGenerationService;
import uk.gov.dvsa.service.RequestParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PdfGenerator implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger logger = LogManager.getLogger(PdfGenerator.class);

    private final EventLogger eventLogger = new EventLogger(logger);

    private RequestParser requestParser;
    private HtmlGeneratorFactory htmlGeneratorFactory;

    public PdfGenerator() {
        eventLogger.logEvent(EventType.CERT_LAMBDA_START);

        this.requestParser = new RequestParser();
        this.htmlGeneratorFactory = new HtmlGeneratorFactory();
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        long start = System.nanoTime();
        eventLogger.logEvent(EventType.CERT_REQUEST_RECEIVED);

        try {
            Document document = requestParser.parseRequest(input);
            List<String> html = htmlGeneratorFactory.create(document.getDocumentName()).generate(document);

            byte [] binaryBody = new PDFGenerationService(new ITextRenderer()).generate(html);

            Map<String, String> headers = new HashMap<>();

            headers.put("Content-Type", "text/plain");
            ApiGatewayResponse response = ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setBinaryBody(binaryBody)
                .setHeaders(headers)
                .build();

            long duration = System.nanoTime() - start;
            eventLogger.logEvent(EventType.CERT_PROCESSED_SUCCESSFULLY, duration);
            return response;
        } catch(Exception e) {
            int statusCode = e instanceof HttpException ? ((HttpException) e).getHttpCode() : 500;
            ApiGatewayResponse response = ApiGatewayResponse.builder()
                .setStatusCode(statusCode)
                .setRawBody(e.getMessage())
                .build();
            long duration = System.nanoTime() - start;
            eventLogger.logError(EventType.CERT_PROCESSED_ERRONEOUSLY, duration, e);
            return response;
        } finally {
            ThreadContext.clearAll();
        }
    }
}
