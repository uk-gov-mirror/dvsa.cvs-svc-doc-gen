package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.lowagie.text.DocumentException;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.mot.VT32VE;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;
import uk.gov.dvsa.service.VT32VEHtmlGenerator;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class VT32VECommonTest {

    private VT32VEHtmlGenerator htmlGenerator;
    private VT32VE testCertificate;
    private MotFailCertificateData expectedData;
    private CertificatePageObject certificatePageObject;

    @Parameterized.Parameters(name = "{index}: Certificate: {0}")
    public static Collection<Object[]> data() {
        return CertificateTestDataProvider.getVT32VECertificatesTestData();
    }


    public VT32VECommonTest(VT32VE testCertificate) {
        this.testCertificate = testCertificate;
        this.expectedData = testCertificate.getFailData();
        this.htmlGenerator = new VT32VEHtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException, DocumentException {
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyTestNumber() {
        String testNumber = certificatePageObject.getTestNumber();
        assertEquals(expectedData.getTestNumber(), testNumber);
    }

    @Test
    public void verifyRegistrationNumber() {
        String registrationNumber = certificatePageObject.getRegistrationNumber();
        assertEquals(expectedData.getRawVrm(), registrationNumber);
    }

    @Test
    public void verifyVin() {
        String vin = certificatePageObject.getVin();
        assertEquals(expectedData.getRawVin(), vin);
    }

    @Test
    public void verifyMake() {
        String make = certificatePageObject.getMake();
        assertEquals(expectedData.getMake(), make);
    }

    @Test
    public void verifyModel() {
        String model = certificatePageObject.getModel();
        assertEquals(expectedData.getModel(), model);
    }

    @Test
    public void verifyOdometer() {
        String odometer = certificatePageObject.getMileage();
        assertEquals(expectedData.getOdometer(), odometer);
    }

    @Test
    public void verifyIssuersName() {
        String issuersName = certificatePageObject.getIssuerInfo();
        assertEquals(expectedData.getIssuersName(), issuersName);
    }

    @Test
    public void verifyIssuedDate() {
        String issuedDate = certificatePageObject.getIssuedDate();
        assertEquals(expectedData.getIssuedDate(), issuedDate);
    }

    @Test
    public void verifyTestStation() {
        String testStation = certificatePageObject.getTestStationId();
        assertEquals(expectedData.getTestStation(), testStation);
    }

    @Test
    public void verifyInspectionAuthority() {
        String inspectionAuthority = certificatePageObject.getInspectionAuthority();
        assertTrue(inspectionAuthority.contains(CertificateTestDataProvider.INSP_AUTHORITY_DVSA));
    }

    @Test
    public void verifyDVSALogoIsLinked() {
        Element dvsaLogoElement = certificatePageObject.getLogo();
        assertNotNull(dvsaLogoElement);

        if (isWelsh()) {
            Element dvsaWelshLogoElement = certificatePageObject.getWelshLogo();
            assertNotNull(dvsaWelshLogoElement);
        }
    }

    private boolean isWelsh() {
        return testCertificate.getDocumentName().contains("W");
    }
}
