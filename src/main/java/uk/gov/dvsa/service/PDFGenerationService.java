package uk.gov.dvsa.service;

import com.lowagie.text.DocumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uk.gov.dvsa.exception.PdfDocumentException;
import uk.gov.dvsa.logging.EventType;
import uk.gov.dvsa.logging.LoggingExecutor;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PDFGenerationService {

    private static final Logger logger = LogManager.getLogger(PDFGenerationService.class);

    private final LoggingExecutor executor = new LoggingExecutor(logger);

    private ITextRenderer renderer;

    public PDFGenerationService(ITextRenderer renderer) {
        this.renderer = renderer;
    }

    public byte[] generate(List<String> htmlContents) {
        return executor.timed(
            () -> runGeneration(htmlContents),
            EventType.CERT_PDF_GENERATION
        );
    }

    private byte[] runGeneration(List<String> htmlContents) {
        ByteArrayOutputStream outputPdf = new ByteArrayOutputStream();

        // render the first HTML document
        render(htmlContents.get(0));

        try {
            renderer.createPDF(outputPdf, false);
        } catch (DocumentException e) {
            throw new PdfDocumentException(e);
        }

        // render the remaining HTML documents
        htmlContents.stream().skip(1).forEach(this::renderHtmlDocument);

        renderer.finishPDF();
        return outputPdf.toByteArray();
    }

    private void renderHtmlDocument(String content) {
        render(content);

        try {
            renderer.writeNextDocument();
        } catch (DocumentException e) {
            throw new PdfDocumentException(e);
        }
    }

    private void render(String content) {
        renderer.setDocumentFromString(content);
        renderer.layout();
    }
}
