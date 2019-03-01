package pdfverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.itextpdf.text.pdf.PdfReader;
import htmlverification.service.CvsCertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdfverification.service.PDFParser;
import uk.gov.dvsa.model.cvs.CvsMotCertificate;
import uk.gov.dvsa.model.mot.VT29;
import uk.gov.dvsa.model.mot.enums.CertificateTypes;
import uk.gov.dvsa.service.HtmlGenerator;
import uk.gov.dvsa.service.PDFGenerationService;

public class VT29Tests {

    private HtmlGenerator htmlGenerator;
    private PDFGenerationService pdfGenerationService;
    private VT29 vt29;
    private PDFParser pdfParser;
    private byte[] pdfData;

    public VT29Tests() {
        this.vt29 = getVT29();

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
        this.pdfGenerationService = new PDFGenerationService(new ITextRenderer());
        this.pdfParser = new PDFParser();
    }

    @Before
    public void before() throws Exception {
        pdfData = pdfGenerationService.generate(htmlGenerator.generate(vt29));
    }

    @Test(expected = NullPointerException.class)
    public void verifySinglePage() throws Exception {
        PdfReader reader = pdfParser.readPdf(pdfData);

        pdfParser.getRawText(reader, 2);
    }

    private VT29 getVT29() {

        VT29 vt29 = new VT29()
                .setDateOfFirstUse("21 Jan 2019")
                .setMake("Test Make")
                .setModel("Test Model")
                .setTestNumber("123456789")
                .setVin("VIN123456789VIN12")
                .setVrm("VRM 123");

        vt29.setDocumentName(CertificateTypes.VT29.getType());

        return vt29;
    }
}
