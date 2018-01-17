package pdf_verification.tests;

import com.itextpdf.text.pdf.PdfReader;
import html_verification.model.CertificateInputData;
import html_verification.service.CertificateTestDataProvider;
import html_verification.service.HtmlGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdf_verification.service.PDFParser;
import uk.gov.dvsa.service.PDFGenerationService;

import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class CommonPDFCertificatesTests {

    @Parameterized.Parameters(name = "{index}: PDF Certificate: {0}")
    public static Collection<Object[]> data() {
        return CertificateTestDataProvider.getCertificatesTestData();
    }

    private HtmlGenerator htmlGenerator;
    private PDFGenerationService pdfGenerationService;
    private CertificateInputData certificateInputData;
    private PDFParser pdfParser;
    private byte[] pdfData;

    public CommonPDFCertificatesTests(CertificateInputData certificateInputData) {
        this.certificateInputData = certificateInputData;

        this.htmlGenerator = new HtmlGenerator();
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
        this.pdfParser = new PDFParser();
    }

    @Before
    public void before() throws Exception {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(certificateInputData));
    }

    @Test
    public void verify_Page_Count_Is_Correct() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        assertEquals(2, reader.getNumberOfPages());
    }

    @Test
    public void verify_Vin_On_Second_Page() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        String vinText = "VIN: QQIDAAAAAAA058568";

        boolean isVinOnFirstPage = pdfParser.getRawText(reader, 1).contains(vinText);
        boolean isVinOnSecondPage = pdfParser.getRawText(reader, 2).contains(vinText);

        assertFalse(isVinOnFirstPage);
        assertTrue(isVinOnSecondPage);
    }
}
