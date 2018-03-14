package pdfverification.tests;

import static junit.framework.TestCase.assertFalse;
import static uk.gov.dvsa.service.VT32VEHtmlGenerator.FOOTER;
import static uk.gov.dvsa.service.VT32VEHtmlGenerator.FOOTER_WELSH;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import htmlverification.service.CertificateTestDataProvider;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.mot.VT32VE;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;
import uk.gov.dvsa.model.mot.enums.Vt32defectsConfig;
import uk.gov.dvsa.service.PDFGenerationService;
import uk.gov.dvsa.service.VT32VEHtmlGenerator;

import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;
import com.lowagie.text.DocumentException;

public class VT32VEWTests {

    private PDFGenerationService pdfGenerationService;
    private VT32VEHtmlGenerator htmlGenerator;
    private PDFParser pdfParser;
    private VT32VE motFailCertificate;
    private MotFailCertificateData expectedData;
    private PdfReader pdfReader;

    public VT32VEWTests() {
        this.htmlGenerator = new VT32VEHtmlGenerator(new Handlebars());
        this.motFailCertificate = CertificateTestDataProvider.getEuVt32VeWelshWithOverflow();
        this.pdfParser = new PDFParser();
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
    }

    @Before
    public void setup() throws IOException, DocumentException {
        byte[] pdfData = pdfGenerationService.generate(htmlGenerator.generate(motFailCertificate));
        pdfReader = pdfParser.readPdf(pdfData);
        expectedData = motFailCertificate.getFailData();
    }

    @Test
    public void verifyTitlesAreOnFirstPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains("Advisory Notice"));
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains("Hysbysiad Ymgynghorol"));
    }

    @Test
    public void verifyQualityInfoTextIsOnSecondPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains(FOOTER));
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains(FOOTER_WELSH));
    }

    @Test
    public void verifyTestNumberIsOnEveryPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains(expectedData.getTestNumber()));
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains(expectedData.getTestNumber()));
    }

    @Test
    public void verifyIssuersNameIsOnEveryPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains(expectedData.getIssuersName()));
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains(expectedData.getIssuersName()));
    }

    @Test
    public void verifyDefectsAreOnFirstPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains(Vt32defectsConfig.MINOR_DEFECTS_WELSH.getHeaderText()));
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains(Vt32defectsConfig.MAJOR_DEFECTS_WELSH.getHeaderText()));
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains(Vt32defectsConfig.DANGEROUS_DEFECTS_WELSH.getHeaderText()));
    }

    @Test
    public void verifyAdvisoryDefectsAreOnSecondPage() throws IOException {
        assertFalse(pdfParser.getRawText(pdfReader, 1).contains(Vt32defectsConfig.ADVISORY_DEFECTS_WELSH.getHeaderText()));
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains(Vt32defectsConfig.ADVISORY_DEFECTS_WELSH.getHeaderText()));
    }

    @Test
    public void verifyPageNumbering() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, 1).contains("Page 1 of 2"));
        assertTrue(pdfParser.getRawText(pdfReader, 2).contains("Page 2 of 2"));
    }
}
