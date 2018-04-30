package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.MotCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateData.PASS_WITH_DEFECTS_HEADER;
import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;

public class Vt20Test {

    protected HtmlGenerator htmlGenerator;
    protected MotCertificate testCertificate;
    protected CertificatePageObject certificatePageObject;

    public Vt20Test() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt20();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyResultSummary() {
        String resultName = certificatePageObject.getDefectSummaryComponent().getResultNameItem().text();
        assertEquals(
            String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER),
            resultName
        );
    }

    @Test
    public void verifyVin() {
        String vin = certificatePageObject.getVin();
        assertEquals(testCertificate.getData().getRawVin(), vin);
    }

    @Test
    public void verifyCountryOfRegistration() {
        String country = certificatePageObject.getCountryOfRegistration();
        assertEquals(testCertificate.getData().getCountryOfRegistrationCode(), country);
    }

    @Test
    public void verifyMakeAndModel() {
        String makeAndModel = certificatePageObject.getMakeAndModel();
        assertEquals(
            String.format("%s %s", testCertificate.getData().getMake(), testCertificate.getData().getModel()),
            makeAndModel
        );
    }

    @Test
    public void verifyVehicleCategory() {
        String vehicleCategory = certificatePageObject.getVehicleCategory();
        assertEquals(testCertificate.getData().getVehicleEuClassification(), vehicleCategory);
    }

    @Test
    public void verifyMileage() {
        String mileage = certificatePageObject.getMileage();
        assertEquals(
            testCertificate.getData().getOdometer(),
            mileage
        );
    }

    @Test
    public void verifyAdvisories() {
        List<String> advisories = certificatePageObject.getDefectSummaryComponent().getAdvisories().eachText();

        assertEquals(3, advisories.size());
    }

    @Test
    public void verifyMinorDefects() {
        List<String> minorDefects = certificatePageObject.getDefectSummaryComponent().getMinorDefects().eachText();

        assertEquals(5, minorDefects.size());
    }

    @Test
    public void verifyDateOfTheTest() {
        String dateOfTheTest = certificatePageObject.getDateOfTheTest();
        assertEquals("12.10.2017", dateOfTheTest);
    }

    @Test
    public void verifyExpiryDate() {
        String expiryDate = certificatePageObject.getExpiryDate();
        assertEquals("12.10.2018", expiryDate);
    }

    @Test
    public void verifyLocationOfTheTest() {
        String location = certificatePageObject.getLocationOfTheTest();
        assertEquals("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom", location);
    }

    @Test
    public void verifyTestingOrganisationAndInspectorsName() {
        String text = certificatePageObject.getTestingOrganisationAndInspectorsName();
        assertEquals("POPULAR GARAGES R.DREWNO", text);
    }

    @Test
    public void verifyMotTestNumber() {
        String testNumber = certificatePageObject.getTestNumber();
        assertEquals("1806 8140 0628", testNumber);
    }
}
