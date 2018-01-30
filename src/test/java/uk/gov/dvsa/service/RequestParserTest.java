package uk.gov.dvsa.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.VT30;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RequestParserTest {
    private RequestParser parser = new RequestParser();

    @Test
    public void parseRequest() throws IOException {
        Map<String, Object> input = readLambdaInput();

        Document document = parser.parseRequest(input);

        assertThat(document.getDocumentName(), equalTo("MOT/VT30"));
        assertThat(((VT30)document).getData().getTestNumber(), equalTo("POC123"));
    }

    private static Map<String, Object> readLambdaInput() throws IOException {
        return new ObjectMapper()
                .readValue(
                    RequestParserTest.class.getResource("/lambdaInput.json"),
                        new TypeReference<HashMap<String, Object>>() {
                    }
                );
    }
}
