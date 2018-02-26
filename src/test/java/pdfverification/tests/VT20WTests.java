package pdfverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.mot.MotCertificate;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;

import static htmlverification.framework.component.DefectSummaryComponent.ADVISORIES_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.ADVISORIES_HEADER_TEXT_WELSH;
import static htmlverification.framework.component.DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT_WELSH;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateData.PASS_WITH_DEFECTS_HEADER;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh.PASS_WITH_DEFECTS_HEADER_WELSH;

public class VT20WTests {

    private HtmlGenerator htmlGenerator;
    private PDFGenerationService pdfGenerationService;
    private MotCertificate testCertificate;
    private PDFParser pdfParser;
    private byte[] pdfData;

    public VT20WTests() {
        this.testCertificate = CertificateTestDataProvider.getVt20W();

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
        this.pdfParser = new PDFParser();
    }

    @Before
    public void before() throws Exception {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));
    }

    @Test
    public void verifyTitle() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 1).contains("Tystysgrif prawf MOT"));
    }

    @Test
    public void verifyHeader() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 1).contains(PASS_WITH_DEFECTS_HEADER_WELSH));
    }

    @Test
    public void verifyRfrs() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 1).contains(MINOR_DEFECTS_HEADER_TEXT_WELSH));
        assertTrue(pdfParser.getRawText(reader, 1).contains(ADVISORIES_HEADER_TEXT_WELSH));
    }

    @Test
    public void verifyVinOnSecondAndForthPage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        String vinText = "VIN: " + CertificateTestDataProvider.VIN;

        boolean isVinOnFirstPage = pdfParser.getRawText(reader, 1).contains(vinText);
        boolean isVinOnSecondPage = pdfParser.getRawText(reader, 2).contains(vinText);
        boolean isVinOnForthPage = pdfParser.getRawText(reader, 4).contains(vinText);

        assertFalse(isVinOnFirstPage);
        assertTrue(isVinOnSecondPage);
        assertTrue(isVinOnForthPage);
    }

    @Test
    public void verifyAdditionalInformationIsNotDisplayed() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        String additionalInfoText = testCertificate.getData().getAdditionalInformation();

        boolean isVinOnFirstPage = pdfParser.getRawText(reader, 1).contains(additionalInfoText);
        boolean isVinOnSecondPage = pdfParser.getRawText(reader, 2).contains(additionalInfoText);

        assertFalse(isVinOnFirstPage);
        assertFalse(isVinOnSecondPage);
    }

    @Test
    public void verifyEnglishCertificateTitleIsOnThirdPage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 3).contains("MOT test certificate"));
    }

    @Test
    public void verifyEnglishHeaderIsOnThirdPage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 3).contains(PASS_WITH_DEFECTS_HEADER));
    }

    @Test
    public void verifyEnglishRfrs() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertTrue(pdfParser.getRawText(reader, 3).contains(MINOR_DEFECTS_HEADER_TEXT));
        assertTrue(pdfParser.getRawText(reader, 3).contains(ADVISORIES_HEADER_TEXT));
    }
}
