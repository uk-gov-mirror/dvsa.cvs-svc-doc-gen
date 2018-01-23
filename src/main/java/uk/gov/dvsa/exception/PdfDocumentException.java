package uk.gov.dvsa.exception;

import com.lowagie.text.DocumentException;

public class PdfDocumentException extends RuntimeException {
    public PdfDocumentException(DocumentException e) {
        super(e);
    }
}
