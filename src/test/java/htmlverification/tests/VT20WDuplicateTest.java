package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class VT20WDuplicateTest extends VT20WTest {

    public VT20WDuplicateTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt20WDuplicate();
        String certHtml = htmlGenerator.generate(testCertificate).get(1);
        certificatePageObject = new CertificatePageObject(certHtml);
        expectedData = (MotCertificateDataWelsh) testCertificate.getData();
    }

    @Test
    public void verifyIssuerInfo() {
        String issuerInfo = certificatePageObject.getIssuerInfo();
        assertEquals(testCertificate.getCertificateIssuerInfoCy(), issuerInfo);
    }
}
