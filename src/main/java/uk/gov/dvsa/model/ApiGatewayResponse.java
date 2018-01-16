package uk.gov.dvsa.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

public class ApiGatewayResponse {

    private final int statusCode;
    private final String body;
    private final Map<String, String> headers;
    private final boolean isBase64Encoded;

    public ApiGatewayResponse(int statusCode, String body, Map<String, String> headers, boolean isBase64Encoded) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
        this.isBase64Encoded = isBase64Encoded;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    // API Gateway expects the property to be called "isBase64Encoded" => isIs
    public boolean isIsBase64Encoded() {
        return isBase64Encoded;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int statusCode = 200;
        private Map<String, String> headers = Collections.emptyMap();
        private String rawBody;
        private byte[] binaryBody;

        public Builder setStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * Builds the {@link ApiGatewayResponse} using the passed raw body string.
         */
        public Builder setRawBody(String rawBody) {
            this.rawBody = rawBody;
            return this;
        }

        /**
         * Builds the {@link ApiGatewayResponse} using the passed binary body
         * encoded as base64.
         */
        public Builder setBinaryBody(byte[] binaryBody) {
            this.binaryBody = binaryBody;
            return this;
        }

        public ApiGatewayResponse build() {
            String body = null;
            boolean base64Encoded = false;
            if (rawBody != null) {
                body = rawBody;
            } else if (binaryBody != null) {
                body = new String(Base64.getEncoder().encode(binaryBody), StandardCharsets.UTF_8);
                base64Encoded = true;
            }
            return new ApiGatewayResponse(statusCode, body, headers, base64Encoded);
        }
    }
}