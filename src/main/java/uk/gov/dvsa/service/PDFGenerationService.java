package uk.gov.dvsa.service;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uk.gov.dvsa.exception.PdfDocumentException;

import java.io.ByteArrayOutputStream;

public class PDFGenerationService {

    protected ITextRenderer renderer;

    public PDFGenerationService(ITextRenderer renderer) {
        this.renderer = renderer;
    }

    public byte[] generate(String htmlContent) {
        ByteArrayOutputStream outputPdf = new ByteArrayOutputStream();

        renderer.setDocumentFromString(htmlContent);
        renderer.layout();

        try {
            renderer.createPDF(outputPdf);
        } catch (DocumentException e) {
            throw new PdfDocumentException(e);
        }

        return outputPdf.toByteArray();
    }
}
