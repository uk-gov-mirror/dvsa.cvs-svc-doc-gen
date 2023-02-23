package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.VT29;
import uk.gov.dvsa.enums.CertificateTypes;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Vt29Test {

    protected HtmlGenerator htmlGenerator;
    protected VT29 vt29;
    protected CertificatePageObject certificatePageObject;

    public Vt29Test() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        vt29 = getVT29();
        String certHtml = htmlGenerator.generate(vt29).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyDateOfFirstUse() {
        String actual = certificatePageObject.getElement("#dateOfFirstUse").text();
        assertEquals("21 Jan 2019", actual);
    }

    @Test
    public void testMakeModel() {
        String actual = certificatePageObject.getElement("#makeModel").text();
        assertEquals("Test Make Test Model", actual);
    }

    @Test
    public void testMakeModelWhereModelIsNotSet() {

        vt29.setModel("");
        String certHtml = htmlGenerator.generate(vt29).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);

        String actual = certificatePageObject.getElement("#makeModel").text();
        assertEquals("Test Make", actual);
    }

    @Test
    public void testMakeModelWhereMakeIsNotSet() {

        vt29.setMake("");
        String certHtml = htmlGenerator.generate(vt29).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);

        String actual = certificatePageObject.getElement("#makeModel").text();
        assertEquals("Test Model", actual);
    }

    @Test
    public void testMakeModelWhereMakeAndModelAreOver40Chars() {

        vt29.setMake("Bentley").setModel("Continental Flying Spur W12 Mulliner");
        String certHtml = htmlGenerator.generate(vt29).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);

        String actual = certificatePageObject.getElement("#makeModel").text();
        assertEquals("Bentley Continental Flying Spur W12 Mull", actual);
    }

    @Test
    public void verifyTestNumber() {
        String actual = certificatePageObject.getElement("#testNumber").text();
        assertEquals("123456789", actual);
    }

    @Test
    public void verifyVin() {
        String actual = certificatePageObject.getElement("#vin").text();
        assertEquals("VIN123456789VIN12", actual);
    }

    @Test
    public void verifyVrm() {
        String actual = certificatePageObject.getElement("#vrm").text();
        assertEquals("VRM 123", actual);
    }

    @Test
    public void verifyFooterDocName() {
        String actual = certificatePageObject.getElement("#footer-doc-name").text();
        assertEquals("VT29/Handwritten/1.1", actual);
    }

    private VT29 getVT29() {

        VT29 vt29 = new VT29()
                .setDateOfFirstUse("21 Jan 2019")
                .setMake("Test Make")
                .setModel("Test Model")
                .setTestNumber("123456789")
                .setVin("VIN123456789VIN12")
                .setVrm("VRM 123");

        vt29.setDocumentName(CertificateTypes.VT29.getCertificateType());

        return vt29;
    }
}
