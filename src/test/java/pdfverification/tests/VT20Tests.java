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

public class VT20Tests {

    private HtmlGenerator htmlGenerator;
    private PDFGenerationService pdfGenerationService;
    private MotCertificate testCertificate;
    private PDFParser pdfParser;
    private byte[] pdfData;

    public VT20Tests() {
        this.testCertificate = CertificateTestDataProvider.getVt20();

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
        this.pdfParser = new PDFParser();
    }

    @Before
    public void before() throws Exception {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));
    }

    @Test(expected = NullPointerException.class)
    public void verifySinglePage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        pdfParser.getRawText(reader, 2);
    }

    @Test
    public void verifySinglePageWithInvalidXMLCharacter() throws Exception {

        this.testCertificate = CertificateTestDataProvider.getVt20HavingInvalidXMLCharacter();
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(testCertificate));

        PdfReader reader = pdfParser.readPdf(pdfData);

        pdfParser.getRawText(reader, 1);
    }
}
