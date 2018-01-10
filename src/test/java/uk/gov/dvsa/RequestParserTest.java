package uk.gov.dvsa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.VT20Certificate;

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

        assertThat(document.getDocumentName(), equalTo("CT20"));
        assertThat(((VT20Certificate)document).getTestNumber(), equalTo("POC123"));
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