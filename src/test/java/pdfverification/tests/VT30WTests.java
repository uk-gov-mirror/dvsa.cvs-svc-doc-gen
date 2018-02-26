package pdfverification.tests;

import static htmlverification.framework.component.DefectSummaryComponent.ADVISORIES_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.ADVISORIES_HEADER_TEXT_WELSH;
import static htmlverification.framework.component.DefectSummaryComponent.DANGEROUS_DEFECTS_HEADER_PARTIAL_TEXT_WELSH;
import static htmlverification.framework.component.DefectSummaryComponent.DANGEROUS_DEFECTS_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.MAJOR_DEFECTS_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.MAJOR_DEFECTS_HEADER_TEXT_WELSH;
import static htmlverification.framework.component.DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT_WELSH;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import htmlverification.service.CertificateTestDataProvider;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.mot.MotFailCertificate;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;

import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;

public class VT30WTests {
    private static final int FIRST_WELSH_PAGE_NUMBER = 3;
    private static final int FIRST_ENGLISH_PAGE_NUMBER = 1;

    private PDFGenerationService pdfGenerationService;
    private HtmlGenerator htmlGenerator;
    private PDFParser pdfParser;
    private MotFailCertificate motFailCertificate;
    private PdfReader pdfReader;
    private byte[] pdfData;

    public VT30WTests() {
        this.motFailCertificate = CertificateTestDataProvider.getVt30W();
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfParser = new PDFParser();
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
    }

    @Before
    public void setup() throws IOException {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(motFailCertificate));
        pdfReader = pdfParser.readPdf(pdfData);
    }

    @Test
    public void verifyWelshTitleIsOnFirstPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_WELSH_PAGE_NUMBER).contains("Gwrthodiad tystysgrif prawf MOT"));
    }

    @Test
    public void verifyEnglishTitleIsOnThirdPage() throws IOException {
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_ENGLISH_PAGE_NUMBER).contains("Refusal of MOT test certificate"));
    }

    @Test
    public void verifyEnglishRfrs() throws Exception {
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_ENGLISH_PAGE_NUMBER).contains(MINOR_DEFECTS_HEADER_TEXT));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_ENGLISH_PAGE_NUMBER).contains(ADVISORIES_HEADER_TEXT));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_ENGLISH_PAGE_NUMBER).contains(MAJOR_DEFECTS_HEADER_TEXT));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_ENGLISH_PAGE_NUMBER).contains(DANGEROUS_DEFECTS_HEADER_TEXT));
    }

    @Test
    public void verifyWelshRfrs() throws Exception {
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_WELSH_PAGE_NUMBER).contains(MINOR_DEFECTS_HEADER_TEXT_WELSH));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_WELSH_PAGE_NUMBER).contains(ADVISORIES_HEADER_TEXT_WELSH));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_WELSH_PAGE_NUMBER).contains(MAJOR_DEFECTS_HEADER_TEXT_WELSH));
        assertTrue(pdfParser.getRawText(pdfReader, FIRST_WELSH_PAGE_NUMBER).contains(DANGEROUS_DEFECTS_HEADER_PARTIAL_TEXT_WELSH));
    }
}
