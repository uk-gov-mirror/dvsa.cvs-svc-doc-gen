package pdfverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.mot.ContingencyCertificate;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ContingencyTests {
    private PDFGenerationService pdfGenerationService;
    private HtmlGenerator htmlGenerator;
    private PDFParser pdfParser;

    public ContingencyTests() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfParser = new PDFParser();
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
    }

    @Test
    public void verifyCT20() throws IOException {
        verifyTestStationNumber(CertificateTestDataProvider.getCt20());
        verifyInspectionAuthority(CertificateTestDataProvider.getCt20());
    }

    @Test
    public void verifyCT30() throws IOException {
        verifyTestStationNumber(CertificateTestDataProvider.getCt30());
        verifyInspectionAuthority(CertificateTestDataProvider.getCt30());
    }

    @Test
    public void verifyCT32() throws IOException {
        verifyTestStationNumber(CertificateTestDataProvider.getCt32());
        verifyInspectionAuthority(CertificateTestDataProvider.getCt32());
    }

    @Test
    public void verifyEuCt20() throws IOException {
        verifyTestStationNumber(CertificateTestDataProvider.getEuCt20());
        verifyInspectionAuthority(CertificateTestDataProvider.getEuCt20());
    }

    @Test
    public void verifyEuCt30() throws IOException {
        verifyTestStationNumber(CertificateTestDataProvider.getEuCt30());
        verifyInspectionAuthority(CertificateTestDataProvider.getEuCt30());
    }

    private void verifyInspectionAuthority(ContingencyCertificate contingencyCertificate) throws IOException {
        PdfReader pdfReader = preparePdf(contingencyCertificate);

        for (String addressLine: contingencyCertificate.getInspectionAuthority()) {
            assertTrue(String.format("The following line is missing in Inspection Authority '%s'", addressLine),
                    pdfParser.getRawText(pdfReader, 1).contains(addressLine));
        }
    }

    private void verifyTestStationNumber(ContingencyCertificate contingencyCertificate) throws IOException {
        PdfReader pdfReader = preparePdf(contingencyCertificate);
        String testStationNumber = contingencyCertificate.getVts();

        assertTrue(String.format("Test Station not found. Expected: '%s'", testStationNumber),
                pdfParser.getRawText(pdfReader, 1).contains(testStationNumber));
    }

    private PdfReader preparePdf(ContingencyCertificate contingencyCertificate) throws IOException {
        byte[] pdfData = pdfGenerationService.generate(htmlGenerator.generate(contingencyCertificate));
        return pdfParser.readPdf(pdfData);
    }
}
