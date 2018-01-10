package uk.gov.dvsa.errors;

public abstract class HttpException extends RuntimeException {
    private final int httpCode;

    public HttpException(String message, int httpCode) {
        super(message);
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public HttpException(String message, Throwable cause, int httpCode) {
        super(message, cause);
        this.httpCode = httpCode;
    }

    public static class BadRequestException extends HttpException {
        public BadRequestException(String message) {
            super(message, 400);
        }

        public BadRequestException(String message, Throwable cause) {
            super(message, cause, 400);
        }
    }

    public static class NotFoundException extends HttpException {
        public NotFoundException(String message) {
            super(message, 404);
        }
    }
}
