package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.exception.HtmlElementNotFoundException;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.PRS;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateData.PASS_WITH_DEFECTS_HEADER;
import static uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData.FAILED_SUMMARY_HEADER;
import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;

public class PRSTest {

    protected HtmlGenerator htmlGenerator;
    protected PRS testCertificate;
    protected CertificatePageObject certificatePageObjectPass;
    protected CertificatePageObject certificatePageObjectFail;

    public PRSTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getPRS();

        String certHtmlPass = htmlGenerator.generate(testCertificate).get(0);
        String certHtmlFail = htmlGenerator.generate(testCertificate).get(1);

        certificatePageObjectPass = new CertificatePageObject(certHtmlPass);
        certificatePageObjectFail = new CertificatePageObject(certHtmlFail);
    }

    @Test
    public void verifyResultSummaries() {
        String resultName = certificatePageObjectPass.getDefectSummaryComponent().getResultNameItem().text();
        String resultNameFail = certificatePageObjectFail.getDefectSummaryComponent().getResultNameItem().text();

        assertEquals(
            String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER),
                resultName
        );
        assertEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, FAILED_SUMMARY_HEADER),
                resultNameFail
        );
    }

    @Test
    public void verifyVin() {
        String vin = certificatePageObjectPass.getVin();
        String vin2 = certificatePageObjectFail.getVin();

        assertEquals(testCertificate.getData().getRawVin(), vin);
        assertEquals(testCertificate.getFailData().getRawVin(), vin2);
    }

    @Test
    public void verifyCountryOfRegistration() {
        String country = certificatePageObjectPass.getCountryOfRegistration();
        String country2 = certificatePageObjectFail.getCountryOfRegistration();

        assertEquals(testCertificate.getData().getCountryOfRegistrationCode(), country);
        assertEquals(testCertificate.getFailData().getCountryOfRegistrationCode(), country2);
    }

    @Test
    public void verifyMakeAndModel() {
        String makeAndModel = certificatePageObjectPass.getMakeAndModel();
        String makeAndModel2 = certificatePageObjectFail.getMakeAndModel();

        assertEquals(
            String.format("%s %s", testCertificate.getData().getMake(), testCertificate.getData().getModel()),
            makeAndModel
        );
        assertEquals(
                String.format("%s %s", testCertificate.getFailData().getMake(), testCertificate.getFailData().getModel()),
                makeAndModel2
        );
    }

    @Test
    public void verifyVehicleCategory() {
        String vehicleCategory = certificatePageObjectPass.getVehicleCategory();
        String vehicleCategory2 = certificatePageObjectFail.getVehicleCategory();

        assertEquals(testCertificate.getData().getVehicleEuClassification(), vehicleCategory);
        assertEquals(testCertificate.getFailData().getVehicleEuClassification(), vehicleCategory2);
    }

    @Test
    public void verifyMileage() {
        String mileage = certificatePageObjectPass.getMileage();
        String mileage2 = certificatePageObjectFail.getMileage();

        assertEquals(testCertificate.getData().getOdometer(), mileage);
        assertEquals(testCertificate.getFailData().getOdometer(), mileage2);
    }

    @Test
    public void verifyAdvisories() {
        List<String> advisories = certificatePageObjectPass.getDefectSummaryComponent().getAdvisories().eachText();

        assertEquals(3, advisories.size());
    }

    @Test
    public void verifyMinorDefects() {
        List<String> minorDefects = certificatePageObjectPass.getDefectSummaryComponent().getMinorDefects().eachText();

        assertEquals(5, minorDefects.size());
    }

    @Test
    public void verifyMajorDefects() {
        List<String> majorDefects = certificatePageObjectFail.getDefectSummaryComponent().getMajorDefects().eachText();

        assertEquals(4, majorDefects.size());
    }

    @Test
    public void verifyDangerousDefects() {
        List<String> dangerousDefects = certificatePageObjectFail.getDefectSummaryComponent().getDangerousDefects().eachText();

        assertEquals(2, dangerousDefects.size());
    }

    @Test
    public void verifyDateOfTheTest() {
        String dateOfTheTest = certificatePageObjectPass.getDateOfTheTest();
        String dateOfTheTest2 = certificatePageObjectFail.getDateOfTheTest();

        assertEquals("12.10.2017", dateOfTheTest);
        assertEquals("12.10.2017", dateOfTheTest2);
    }

    @Test
    public void verifyLocationOfTheTest() {
        String location = certificatePageObjectPass.getLocationOfTheTest();
        String location2 = certificatePageObjectFail.getLocationOfTheTest();

        assertEquals("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom", location);
        assertEquals("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom", location2);
    }

    @Test
    public void verifyTestingOrganisationAndInspectorsName() {
        String text = certificatePageObjectPass.getTestingOrganisationAndInspectorsName();
        String text2 = certificatePageObjectFail.getTestingOrganisationAndInspectorsName();

        assertEquals("MILKE GROUP LIMITED R.DREWNO", text);
        assertEquals("MILKE GROUP LIMITED R.DREWNO", text2);
    }

    @Test
    public void verifyMotTestNumber() {
        String testNumber = certificatePageObjectPass.getTestNumber();
        String testNumber2 = certificatePageObjectFail.getTestNumber();

        assertEquals("1806 8140 0628", testNumber);
        assertEquals("1806 8140 0628", testNumber2);
    }

    @Test
    public void verifyExpiryDateOnPassIsPresent() {
        String expiryDate = certificatePageObjectPass.getExpiryDate();

        assertEquals("12.10.2018", expiryDate);
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyExpiryDateIsNotPresentOnFail() {
        certificatePageObjectFail.getExpiryDate();
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyEarliestDateOfTheNextTestIsNotPresentOnFail() {
        certificatePageObjectFail.getEarliestDateOfTheNextTest();
    }
}
