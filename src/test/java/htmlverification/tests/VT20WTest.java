package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.component.MileageHistoryComponent;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.framework.page_object.CertificatePageSelector;
import htmlverification.service.CertificateTestDataProvider;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.VT20W;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static htmlverification.framework.component.DefectSummaryComponent.ADVISORIES_HEADER_TEXT;
import static htmlverification.framework.component.DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT;
import static htmlverification.service.CertificateTestDataProvider.ODOMETER_VALUE;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateData.PASS_WITH_DEFECTS_HEADER;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh.PASS_WITH_DEFECTS_HEADER_WELSH;
import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;
import static uk.gov.dvsa.view.mot.OdometerReadingFormatter.MILES_WELSH;

public class VT20WTest {

    protected HtmlGenerator htmlGenerator;
    protected VT20W testCertificate;
    protected CertificatePageObject certificatePageObject;
    protected MotCertificateDataWelsh expectedData;

    public VT20WTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt20W();
        String certHtml = htmlGenerator.generate(testCertificate).get(1);
        certificatePageObject = new CertificatePageObject(certHtml);
        expectedData = (MotCertificateDataWelsh) testCertificate.getData();
    }

    @Test
    public void verifyResultSummary() {
        String resultName = certificatePageObject.getDefectSummaryComponent().getResultNameItem().text();
        assertEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER_WELSH),
                resultName
        );
    }

    @Test
    public void verifyEnglishHeaderNotPresent() {
        String resultName = certificatePageObject.getDefectSummaryComponent().getResultNameItem().text();
        assertNotEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER),
                resultName
        );
    }

    @Test
    public void verifyVin() {
        String vin = certificatePageObject.getVin();
        assertEquals(expectedData.getRawVin(), vin);
    }

    @Test
    public void verifyCountryOfRegistration() {
        String country = certificatePageObject.getCountryOfRegistration();
        assertEquals(expectedData.getCountryOfRegistrationCode(), country);
    }

    @Test
    public void verifyMakeAndModel() {
        String makeAndModel = certificatePageObject.getMakeAndModel();
        assertEquals(
                String.format("%s %s", expectedData.getMake(), expectedData.getModel()),
                makeAndModel
        );
    }

    @Test
    public void verifyVehicleCategory() {
        String vehicleCategory = certificatePageObject.getVehicleCategory();
        assertEquals(expectedData.getVehicleEuClassification(), vehicleCategory);
    }

    @Test
    public void verifyMileage() {
        String mileage = certificatePageObject.getMileage();
        assertEquals(ODOMETER_VALUE + " " + MILES_WELSH, mileage);
    }

    @Test()
    public void verifyAdvisories() {
        List<String> advisories = certificatePageObject.getDefectSummaryComponent().getAdvisoriesWelsh().eachText();

        assertEquals(3, advisories.size());
        for (int i = 0; i < advisories.size(); i++) {
            assertEquals(expectedData.getEuAdvisoryDefectsCy().get(i), advisories.get(i));
        }
        for (int i = 0; i < advisories.size(); i++) {
            assertNotEquals(expectedData.getEuAdvisoryDefects().get(i), advisories.get(i));
        }
    }

    @Test
    public void verifyEnglishAdvisoriesNotPresent() {
        assertEquals(false,
                certificatePageObject.getDefectSummaryComponent().isDefectsHeaderPresent(ADVISORIES_HEADER_TEXT));
    }

    @Test
    public void verifyMinorDefects() {
        List<String> minorDefects = certificatePageObject.getDefectSummaryComponent().getMinorDefectsWelsh().eachText();

        assertEquals(5, minorDefects.size());
        for (int i = 0; i < minorDefects.size(); i++) {
            assertEquals(expectedData.getEuMinorDefectsCy().get(i), minorDefects.get(i));
        }

        for (int i = 0; i < minorDefects.size(); i++) {
            assertNotEquals(expectedData.getEuMinorDefects().get(i), minorDefects.get(i));
        }
    }

    @Test
    public void verifyEnglishMinorDefectsNotPresent() {
        assertFalse(certificatePageObject.getDefectSummaryComponent().isDefectsHeaderPresent(MINOR_DEFECTS_HEADER_TEXT));
    }

    @Test
    public void verifyDateOfTheTest() {
        String dateOfTheTest = certificatePageObject.getDateOfTheTest();
        assertEquals("12.10.2017", dateOfTheTest);
    }

    @Test
    public void verifyExpiryDate() {
        String expiryDate = certificatePageObject.getExpiryDate();
        assertEquals(expectedData.getExpiryDate(), expiryDate);
    }

    @Test
    public void verifyLocationOfTheTest() {
        String location = certificatePageObject.getLocationOfTheTest();
        assertEquals(expectedData.getTestStationAddressLine(), location);
    }

    @Test
    public void verifyTestingOrganisationAndInspectorsName() {
        String text = certificatePageObject.getTestingOrganisationAndInspectorsName();
        assertEquals(expectedData.getInspectionAuthority(), text);
    }

    @Test
    public void verifyMotTestNumber() {
        String testNumber = certificatePageObject.getTestNumber();
        assertEquals(expectedData.getTestNumber(), testNumber);
    }

    @Test
    public void verifyEarliestDateOfTheNextTest() {
        String earliestDateOfTheNextTest = certificatePageObject.getEarliestDateOfTheNextTest();
        assertEquals("13.10.2018", earliestDateOfTheNextTest);
    }

    @Test
    public void verifyDVSALogoIsLinked() {
        Element dvsaLogoElement = certificatePageObject.getWelshLogo();
        assertNotNull(dvsaLogoElement);
    }

    @Test
    public void verifyMileageHistoryEntriesCount() {
        MileageHistoryComponent mileageHistoryComponent = certificatePageObject.getMileageHistoryComponent();
        assertTrue(mileageHistoryComponent.getEntries().size() <= 3);
    }
}
