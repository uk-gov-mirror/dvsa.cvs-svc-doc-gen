package uk.gov.dvsa;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.jknack.handlebars.Handlebars;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uk.gov.dvsa.errors.HttpException;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.ApiGatewayResponse;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;
import uk.gov.dvsa.service.RequestParser;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class PdfGenerator implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private RequestParser requestParser;
    private HtmlGenerator htmlGenerator;

    public PdfGenerator() {
        this.requestParser = new RequestParser();
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of PdfGenerator");

        try {
            Document document = requestParser.parseRequest(input);
            String html = htmlGenerator.generate(document.getDocumentName(), document);
            byte [] binaryBody = new PDFGenerationService(new ITextRenderer()).generate(html);

            Map<String, String> headers = new HashMap<>();

            headers.put("Content-Type", "application/json");
            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setBinaryBody(binaryBody)
                    .setHeaders(headers)
                    .build();

        } catch (HttpException e) {
            logger.log(e.getMessage());
            return ApiGatewayResponse.builder()
                    .setStatusCode(e.getHttpCode())
                    .setRawBody(e.getMessage())
                    .build();
        } catch(Exception e) {
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setRawBody(e.getMessage())
                    .build();
        }


    }

}
