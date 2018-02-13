package uk.gov.dvsa.exception;

import java.io.IOException;

public class HtmlTemplateCompilationException extends RuntimeException{
    public HtmlTemplateCompilationException(IOException e) {
        super(e);
    }

    @Override
    public String getMessage() {
        return String.format("Could not compile HTML template: %s", super.getMessage());
    }
}
