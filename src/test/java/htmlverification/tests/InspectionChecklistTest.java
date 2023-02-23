package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.InspectionChecklist;
import uk.gov.dvsa.enums.CertificateTypes;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class InspectionChecklistTest {

    protected HtmlGenerator htmlGenerator;
    protected InspectionChecklist inspectionChecklist;
    protected CertificatePageObject certificatePageObject;

    public InspectionChecklistTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        inspectionChecklist = getInspectionChecklist();
        String certHtml = htmlGenerator.generate(inspectionChecklist).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyBrakeWeight() {
        String actual = certificatePageObject.getElement("#brake-weight").text();
        assertEquals("1000 kg", actual);
    }

    @Test
    public void verifyCylinderCapacity() {
        String actual = certificatePageObject.getElement("#cylinder-capacity").text();
        assertEquals("1000", actual);
    }

    @Test
    public void verifyDate() {
        String actual = certificatePageObject.getElement("#date").text();
        assertEquals("21 Jan 2019", actual);
    }

    @Test
    public void verifyEuCategory() {
        String actual = certificatePageObject.getElement("#eu-category").text();
        assertEquals("M1", actual);
    }

    @Test
    public void verifyFirstUseDate() {
        String actual = certificatePageObject.getElement("#first-use").text();
        assertEquals("20 Jan 2016", actual);
    }

    @Test
    public void verifyMakeModelUnder40CharactersTotal() {
        String actual = certificatePageObject.getElement("#make-model").text();
        assertEquals("Hyundai i20", actual);
    }

    @Test
    public void verifyMakeAndModelOver40CharactersIsTrimmed() {

        inspectionChecklist
                .setMake("Bentley Continental Flying Spur")
                .setModel("W12 Mulliner");

        String certHtml = htmlGenerator.generate(inspectionChecklist).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);

        String actual = certificatePageObject.getElement("#make-model").text();
        assertEquals("Bentley Continental Flying Spur W12 Mull", actual);
    }

    @Test
    public void verifyRegistrationMark() {
        String actual = certificatePageObject.getElement("#reg").text();
        assertEquals("VRM 1234", actual);
    }

    @Test
    public void verifyTesterName() {
        String actual = certificatePageObject.getElement("#tester-name").text();
        assertEquals("Mr John Doe", actual);
    }

    @Test
    public void verifyTime() {
        String actual = certificatePageObject.getElement("#time").text();
        assertEquals("10am", actual);
    }

    @Test
    public void verifyVin() {
        String actual = certificatePageObject.getElement("#vin").text();
        assertEquals("123456789ABCDEFGH", actual);
    }

    @Test
    public void verifyVts() {
        String actual = certificatePageObject.getElement("#vts").text();
        assertEquals("test station 180", actual);
    }

    private InspectionChecklist getInspectionChecklist() {

        InspectionChecklist inspectionChecklist = new InspectionChecklist();

        inspectionChecklist.setDocumentName(CertificateTypes.INSPECTION_CHECKLIST.getCertificateType());

        return inspectionChecklist
                .setBrakeWeight("1000 kg")
                .setCylinderCapacity("1000")
                .setDate("21 Jan 2019")
                .setEuCategory("M1")
                .setFirstUse("20 Jan 2016")
                .setMake("Hyundai")
                .setModel("i20")
                .setRegistrationMark("VRM 1234")
                .setTesterName("Mr John Doe")
                .setTime("10am")
                .setVin("123456789ABCDEFGH")
                .setVts("test station 180");
    }
}
