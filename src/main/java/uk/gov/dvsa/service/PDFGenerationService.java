package uk.gov.dvsa.service;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

public class PDFGenerationService {

    protected ITextRenderer renderer;

    public PDFGenerationService(ITextRenderer renderer) {
        this.renderer = renderer;
    }

    public byte[] generate(String htmlContent) throws DocumentException {
        ByteArrayOutputStream outputPdf = new ByteArrayOutputStream();

        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputPdf);

        return outputPdf.toByteArray();
    }
}
