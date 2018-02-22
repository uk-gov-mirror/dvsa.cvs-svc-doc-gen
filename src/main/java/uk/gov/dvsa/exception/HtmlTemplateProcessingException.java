package uk.gov.dvsa.exception;

import java.io.IOException;

public class HtmlTemplateProcessingException extends RuntimeException{
    public HtmlTemplateProcessingException(IOException e) {
        super(e);
    }

    @Override
    public String getMessage() {
        return String.format("Could not apply data to HTML template: %s", super.getMessage());
    }
}
