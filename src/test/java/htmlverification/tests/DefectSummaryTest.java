package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.gov.dvsa.model.mot.MotFailCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

        assertEquals("Fail", resultName);
    }

    @Test
    public void verifyAdvisories() {
        List<String> advisories = certificatePageObject.getDefectSummaryComponent().getAdvisories().eachText();

        assertEquals(3, advisories.size());
    }

    @Test
    @Ignore("Skipping test. There are no minor defects in the model yet")
    public void verifyMinorDefects() {
        List<String> minorDefects = certificatePageObject.getDefectSummaryComponent().getMinorDefects().eachText();

        assertEquals(20, minorDefects.size());
    }
}
