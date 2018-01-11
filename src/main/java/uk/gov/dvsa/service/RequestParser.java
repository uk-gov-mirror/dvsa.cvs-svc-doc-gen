package uk.gov.dvsa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.gov.dvsa.errors.HttpException;
import uk.gov.dvsa.model.VT30v20;
import uk.gov.dvsa.model.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    private static final String PATH_PARAMETERS = "pathParameters";
    private static final String DOCUMENT_NAME_PARAMETER = "reportName";
    private static final String REQUEST_BODY = "body";

    private static final Map<String, Class<? extends Document>> documents;

    static {
        HashMap<String, Class<? extends Document>> reportsMap = new HashMap<>();
        reportsMap.put("VT30_v2_0", VT30v20.class);
        documents = Collections.unmodifiableMap(reportsMap);
    }

    public Document parseRequest(Map<String, Object> input) {
        String documentName = readDocumentName(input);
        Class<? extends Document> ReportType = readDocumentType(documentName);
        String documentJson = readRequestBody(input);

        try {
            ObjectMapper om = new ObjectMapper();
            Document document = om.readValue(documentJson, ReportType);
            document.setDocumentName(documentName);
            return document;
        } catch (IOException e) {
            throw new HttpException.BadRequestException("Error parsing parameters", e);
        }
    }

    private Class<? extends Document> readDocumentType(String documentName) {
        return documents.get(documentName);
    }

    private static String readDocumentName(Map<String, Object> input) {
        if (!input.containsKey(PATH_PARAMETERS)) {
            throw new HttpException.BadRequestException("Expecting parameter " + PATH_PARAMETERS);
        }

        Map<String, String> pathParameters = (Map<String, String>) input.get(PATH_PARAMETERS);

        if (!pathParameters.containsKey(DOCUMENT_NAME_PARAMETER)) {
            throw new HttpException.BadRequestException("Expecting path parameter " + DOCUMENT_NAME_PARAMETER);
        }

        String documentName = pathParameters.get(DOCUMENT_NAME_PARAMETER);

        if (!documents.containsKey(documentName)) {
            throw new HttpException.NotFoundException("Unknown report name");
        }

        return documentName;
    }

    private static String readRequestBody(Map<String, Object> input) {
        if (!input.containsKey(REQUEST_BODY)) {
            throw new HttpException.BadRequestException("Expecting parameter " + REQUEST_BODY);
        }
        return (String) (input.get(REQUEST_BODY));
    }
}
