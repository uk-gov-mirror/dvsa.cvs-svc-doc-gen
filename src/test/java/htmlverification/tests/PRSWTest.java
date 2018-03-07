package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.exception.HtmlElementNotFoundException;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.PRSW;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateData.PASS_WITH_DEFECTS_HEADER;
import static uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh.PASS_WITH_DEFECTS_HEADER_WELSH;
import static uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData.FAILED_SUMMARY_HEADER;
import static uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh.FAIL_SUMMARY_HEADER_WELSH;
import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;

public class PRSWTest {

    protected HtmlGenerator htmlGenerator;
    protected PRSW testCertificate;
    protected CertificatePageObject certificatePageObjectPass;
    protected CertificatePageObject certificatePageObjectFail;
    protected CertificatePageObject certificatePageObjectPassWelsh;
    protected CertificatePageObject certificatePageObjectFailWelsh;

    public PRSWTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getPRSW();

        String certHtmlPass = htmlGenerator.generate(testCertificate).get(0);
        String certHtmlFail = htmlGenerator.generate(testCertificate).get(1);
        String certHtmlPassWelsh = htmlGenerator.generate(testCertificate).get(2);
        String certHtmlFailWelsh = htmlGenerator.generate(testCertificate).get(3);

        certificatePageObjectPass = new CertificatePageObject(certHtmlPass);
        certificatePageObjectFail = new CertificatePageObject(certHtmlFail);
        certificatePageObjectPassWelsh = new CertificatePageObject(certHtmlPassWelsh);
        certificatePageObjectFailWelsh = new CertificatePageObject(certHtmlFailWelsh);
    }

    @Test
    public void verifyResultSummaries() {
        String resultName = certificatePageObjectPass.getDefectSummaryComponent().getResultNameItem().text();
        String resultNameFail = certificatePageObjectFail.getDefectSummaryComponent().getResultNameItem().text();
        String resultNameWelsh = certificatePageObjectPassWelsh.getDefectSummaryComponent().getResultNameItem().text();
        String resultNameFailWelsh = certificatePageObjectFailWelsh.getDefectSummaryComponent().getResultNameItem().text();

        assertEquals(
            String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER),
                resultName
        );
        assertEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, FAILED_SUMMARY_HEADER),
                resultNameFail
        );
        assertEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, PASS_WITH_DEFECTS_HEADER_WELSH),
                resultNameWelsh
        );
        assertEquals(
                String.format("%s %s", EU_NUMBER_SUMMARY_HEADER, FAIL_SUMMARY_HEADER_WELSH),
                resultNameFailWelsh
        );
    }

    @Test
    public void verifyMileage() {
        String mileage = certificatePageObjectPass.getMileage();
        String mileage2 = certificatePageObjectFail.getMileage();
        String mileage3 = certificatePageObjectPass.getMileage();
        String mileage4 = certificatePageObjectFail.getMileage();

        assertEquals(testCertificate.getData().getOdometer(), mileage);
        assertEquals(testCertificate.getFailData().getOdometer(), mileage2);
        assertEquals(testCertificate.getData().getOdometer(), mileage3);
        assertEquals(testCertificate.getFailData().getOdometer(), mileage4);
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
    public void verifyAdvisoriesWelsh() {
        List<String> advisories = certificatePageObjectPassWelsh.getDefectSummaryComponent().getAdvisoriesWelsh().eachText();

        assertEquals(3, advisories.size());
    }

    @Test
    public void verifyMinorDefectsWelsh() {
        List<String> minorDefects = certificatePageObjectPassWelsh.getDefectSummaryComponent().getMinorDefectsWelsh().eachText();

        assertEquals(5, minorDefects.size());
    }

    @Test
    public void verifyMajorDefectsWelsh() {
        List<String> majorDefects = certificatePageObjectFailWelsh.getDefectSummaryComponent().getMajorDefectsWelsh().eachText();

        assertEquals(4, majorDefects.size());
    }

    @Test
    public void verifyDangerousDefectsWelsh() {
        List<String> dangerousDefects = certificatePageObjectFailWelsh.getDefectSummaryComponent().getDangerousDefectsWelsh().eachText();

        assertEquals(2, dangerousDefects.size());
    }

    @Test
    public void verifyExpiryDateOnPassesIsPresent() {
        String expiryDate = certificatePageObjectPass.getExpiryDate();
        String expiryDate2 = certificatePageObjectPassWelsh.getExpiryDate();

        assertEquals("12.10.2018", expiryDate);
        assertEquals("12.10.2018", expiryDate2);
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyExpiryDateIsNotPresentOnFail() {
        certificatePageObjectFail.getExpiryDate();
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyExpiryDateIsNotPresentOnFailWelsh() {
        certificatePageObjectFailWelsh.getExpiryDate();
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyEarliestDateOfTheNextTestIsNotPresentOnFail() {
        certificatePageObjectFail.getEarliestDateOfTheNextTest();
    }

    @Test(expected = HtmlElementNotFoundException.class)
    public void verifyEarliestDateOfTheNextTestIsNotPresentOnFailWelsh() {
        certificatePageObjectFailWelsh.getEarliestDateOfTheNextTest();
    }
}
