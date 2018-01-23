package uk.gov.dvsa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.gov.dvsa.exception.HttpException;
import uk.gov.dvsa.model.mot.VT30;
import uk.gov.dvsa.model.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    private static final String PATH_PARAMETERS = "pathParameters";
    private static final String DOCUMENT_NAME_PARAMETER = "documentName";
    private static final String DOCUMENT_DIRECTORY_PARAMETER = "documentDirectory";
    private static final String REQUEST_BODY = "body";

    private static final Map<String, Class<? extends Document>> documents;

    static {
        HashMap<String, Class<? extends Document>> documentsMap = new HashMap<>();
        documentsMap.put("MOT/VT30", VT30.class);
        documents = Collections.unmodifiableMap(documentsMap);
    }

    public Document parseRequest(Map<String, Object> input) {
        String documentName = readDocumentName(input);
        Class<? extends Document> documentType = readDocumentType(documentName);
        String documentJson = readRequestBody(input);

        try {
            ObjectMapper om = new ObjectMapper();
            Document document = om.readValue(documentJson, documentType);
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
            throw new HttpException.BadRequestException("Required lambda parameter " + PATH_PARAMETERS + " not found");
        }

        Map<String, String> pathParameters = (Map<String, String>) input.get(PATH_PARAMETERS);

        if (!pathParameters.containsKey(DOCUMENT_NAME_PARAMETER)) {
            throw new HttpException.BadRequestException("Required path parameter " + DOCUMENT_NAME_PARAMETER + " not found");
        }

        if (!pathParameters.containsKey(DOCUMENT_DIRECTORY_PARAMETER)) {
            throw new HttpException.BadRequestException("Required path parameter " + DOCUMENT_DIRECTORY_PARAMETER + " not found");
        }

        String documentName = pathParameters.get(DOCUMENT_NAME_PARAMETER);
        String documentDirectory = pathParameters.get(DOCUMENT_DIRECTORY_PARAMETER);

        String documentPath = trimFileExtension(documentDirectory + "/" + documentName);

        if (!documents.containsKey(documentPath)) {
            throw new HttpException.NotFoundException("Unknown document name: " + documentPath);
        }

        return documentPath;
    }

    private static String trimFileExtension(String documentPath) {
        int dotPosition = documentPath.lastIndexOf('.');

        if (dotPosition > 0) {
            return documentPath.substring(0, dotPosition);
        }
        return documentPath;
    }


    private static String readRequestBody(Map<String, Object> input) {
        if (!input.containsKey(REQUEST_BODY)) {
            throw new HttpException.BadRequestException("Required lambda parameter " + REQUEST_BODY + " not found");
        }
        return (String) (input.get(REQUEST_BODY));
    }
}
