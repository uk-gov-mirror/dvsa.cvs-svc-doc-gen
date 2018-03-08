package pdfverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.mot.MotFailCertificate;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class VT30Tests {

    private HtmlGenerator htmlGenerator;
    private PDFGenerationService pdfGenerationService;
    private MotFailCertificate testCertificate;
    private PDFParser pdfParser;
    private byte[] pdfData;

    public VT30Tests() {
        this.testCertificate = CertificateTestDataProvider.getVt30WithOverflownRFRs();

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
        this.pdfParser = new PDFParser();
    }

    @Before
    public void before() throws Exception {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));
    }

    @Test
    public void verifyPageCountIsCorrect() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertEquals(3, reader.getNumberOfPages());
    }

    @Test
    public void verifyVinOnSecondPage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        String vinText = "VIN: " + CertificateTestDataProvider.VIN;

        boolean isVinOnFirstPage = pdfParser.getRawText(reader, 1).contains(vinText);
        boolean isVinOnSecondPage = pdfParser.getRawText(reader, 2).contains(vinText);

        assertFalse(isVinOnFirstPage);
        assertTrue(isVinOnSecondPage);
    }

    @Test
    public void verifyRfrsOverflowToSecondPage() throws Exception {

        List<String> expectedFirstPageRfrs = new ArrayList<>();
        IntStream.range(0, 29).forEach(number ->
                expectedFirstPageRfrs.add(CertificateTestDataProvider.DANGEROUS_RFR_TEXT + " #" + number + "\n")
        );

        List<String> expectedSecondPageRfrs = new ArrayList<>();
        IntStream.range(30, 60).forEach(number ->
                expectedSecondPageRfrs.add(CertificateTestDataProvider.DANGEROUS_RFR_TEXT + " #" + number + "\n")
        );

        PdfReader reader = pdfParser.readPdf(pdfData);
        String firstPageText = pdfParser.getRawText(reader, 1);
        String secondPageText = pdfParser.getRawText(reader, 2);

        expectedFirstPageRfrs.forEach(rfr -> assertTrue(rfr + " should appear on the first page", firstPageText.contains(rfr)));
        expectedFirstPageRfrs.forEach(rfr -> assertFalse(rfr + " should not appear on the second page ", secondPageText.contains(rfr)));
        expectedSecondPageRfrs.forEach(rfr -> assertTrue(rfr + " should appear on the second page", secondPageText.contains(rfr)));
        expectedSecondPageRfrs.forEach(rfr -> assertFalse(rfr + " should not appear on the first page", firstPageText.contains(rfr)));
    }
}
