package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.MotFailCertificate;
import uk.gov.dvsa.model.mot.MotFailCertificateData;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;

public class DefectSummaryTest {

    protected HtmlGenerator htmlGenerator;
    protected MotFailCertificate testCertificate;
    protected CertificatePageObject certificatePageObject;

    public DefectSummaryTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt30();
        String certHtml = htmlGenerator.generate(testCertificate);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyResultName() {
        String resultName = certificatePageObject.getDefectSummaryComponent().getResultNameItem().text();

        assertEquals(String.format("%s %s",
                EU_NUMBER_SUMMARY_HEADER, MotFailCertificateData.FAILED_SUMMARY_HEADER),
                resultName);
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
    public void verifyDangerousDefects() {
        List<String> dangerousDefects = certificatePageObject.getDefectSummaryComponent().getDangerousDefects().eachText();

        assertEquals(2, dangerousDefects.size());
    }

    @Test
    public void verifyMajorDefects() {
        List<String> majorDefects = certificatePageObject.getDefectSummaryComponent().getMajorDefects().eachText();

        assertEquals(4, majorDefects.size());
    }
}
