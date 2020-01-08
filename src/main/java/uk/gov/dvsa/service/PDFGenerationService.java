package uk.gov.dvsa.service;

import com.lowagie.text.DocumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uk.gov.dvsa.exception.PdfDocumentException;
import uk.gov.dvsa.helper.XMLCleanerHelper;
import uk.gov.dvsa.logging.EventType;
import uk.gov.dvsa.logging.LoggingExecutor;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
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
            clearBookmarks();
        } catch (DocumentException e) {
            throw new PdfDocumentException(e);
        }

        // render the remaining HTML documents
        htmlContents.stream().skip(1).forEach(this::renderHtmlDocument);

        renderer.finishPDF();
        return outputPdf.toByteArray();
    }

//     The function is introduced, because of a bug in flying-saucer library. (BL-7412 ticket on jira)
//     The problem occurs when there are multiple certificates being printed and they differ with page numbers
//     e.g. welsh and english pass certificate - welsh is printed as a first and it consists of 2 pages, but
//     the english version content fits on 1 page - then flying-saucer would count 4 pages, because the bookmarks list
//     is not cleared after every html document being rendered. Problem is that physically there are only 3 pages, so
//     it would give us an error, to avoid that we should clear the list after every html document rendering.
//                                          *** IMPORTANT ***
//     after every createPdf() or writeNextDocument() method call this should be executed as well
    private void clearBookmarks() {
        try {
            Field privateBookmarksList = renderer.getOutputDevice().getClass().getDeclaredField("_bookmarks");
            privateBookmarksList.setAccessible(true);
            List bookmarksList = (List) privateBookmarksList.get(renderer.getOutputDevice());
            bookmarksList.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void renderHtmlDocument(String content) {
        render(content);

        try {
            renderer.writeNextDocument();
            clearBookmarks();
        } catch (DocumentException e) {
            throw new PdfDocumentException(e);
        }
    }

    private void render(String content) {
        renderer.setDocumentFromString(
                XMLCleanerHelper.stripInvalidXMLCharacters(content)
        );
        renderer.layout();
    }
}
