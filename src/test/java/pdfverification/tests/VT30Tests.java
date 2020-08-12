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

import java.io.IOException;
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

    private static final String ISSUER_SIGNATURE = "Issuer signature";
    private static final String ISSUED_BY_DVSA = "Issued by DVSA";

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
        IntStream.range(0, 27).forEach(number ->
                expectedFirstPageRfrs.add(CertificateTestDataProvider.DANGEROUS_RFR_TEXT + " #" + number + "\n")
        );

        List<String> expectedSecondPageRfrs = new ArrayList<>();
        IntStream.range(28, 60).forEach(number ->
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


    @Test
    public void verifyIssuerSignatureIsReplacedByDvsaWhenRequested() throws IOException {
        this.testCertificate = CertificateTestDataProvider.getMultiPageVt30WithHiddenIssuerInfo();
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));

        PdfReader reader = pdfParser.readPdf(pdfData);

        // 1st page is handled differently than the subsequent pages,
        // the signature has to be verified on pages 1 & 2 to cover different cases
        assertFalse(pdfParser.getRawText(reader, 1).contains(ISSUER_SIGNATURE));
        assertFalse(pdfParser.getRawText(reader, 2).contains(ISSUER_SIGNATURE));

        assertTrue(pdfParser.getRawText(reader, 1).contains(ISSUED_BY_DVSA));
        assertTrue(pdfParser.getRawText(reader, 2).contains(ISSUED_BY_DVSA));
    }

    @Test
    public void verifyIssuerSignatureIsVisibleWhenRequested() throws IOException {
        this.testCertificate = CertificateTestDataProvider.getMultiPageVt30WithVisibleIssuerInfo();
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));

        PdfReader reader = pdfParser.readPdf(pdfData);

        // 1st page is handled differently than the subsequent pages,
        // the signature has to be verified on pages 1 & 2 to cover different cases
        assertTrue(pdfParser.getRawText(reader, 1).contains(ISSUER_SIGNATURE));
        assertTrue(pdfParser.getRawText(reader, 2).contains(ISSUER_SIGNATURE));

        assertFalse(pdfParser.getRawText(reader, 1).contains(ISSUED_BY_DVSA));
        assertFalse(pdfParser.getRawText(reader, 2).contains(ISSUED_BY_DVSA));
    }

    @Test
    public void verifyIssuerSignatureShowsUpByDefaultWhenItIsNotSpecified() throws IOException {
        this.testCertificate = CertificateTestDataProvider.getMultiPageVt30WithUnspecifiedIssuerVisibilitySetting();
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));

        PdfReader reader = pdfParser.readPdf(pdfData);

        // 1st page is handled differently than the subsequent pages,
        // the signature has to be verified on pages 1 & 2 to cover different cases
        assertTrue(pdfParser.getRawText(reader, 1).contains(ISSUER_SIGNATURE));
        assertTrue(pdfParser.getRawText(reader, 2).contains(ISSUER_SIGNATURE));

        assertFalse(pdfParser.getRawText(reader, 1).contains(ISSUED_BY_DVSA));
        assertFalse(pdfParser.getRawText(reader, 2).contains(ISSUED_BY_DVSA));
    }
}
