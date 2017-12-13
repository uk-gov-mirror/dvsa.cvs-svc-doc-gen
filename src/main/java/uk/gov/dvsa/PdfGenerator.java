package uk.gov.dvsa;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import org.apache.commons.io.FileUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class PdfGenerator implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of PdfGenerator");

        try{

            ByteArrayOutputStream outputPdf = new ByteArrayOutputStream();
            String html = getHtmlContent();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputPdf);

            byte [] binaryBody = outputPdf.toByteArray();

            Map<String, String> headers = new HashMap<>();

            headers.put("Content-Type", "application/json");
            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setBinaryBody(binaryBody)
                    .setHeaders(headers)
                    .build();

        }
        catch(Exception e)
        {
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setRawBody(e.getMessage())
                    .build();
        }


    }

    private static String getHtmlContent() throws URISyntaxException, IOException {
        URL indexUrl = PdfGenerator.class.getResource("/index3.html");

        File indexContent = new File(indexUrl.toURI());
        return FileUtils.readFileToString(indexContent, "UTF-8");  // or any other encoding
    }


}