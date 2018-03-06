package htmlverification.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;
import uk.gov.dvsa.service.HtmlGenerator;

import org.junit.Before;
import org.junit.Test;

import com.github.jknack.handlebars.Handlebars;

public class VT30WDuplicateTest extends VT30WTest {

    public VT30WDuplicateTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt30WDuplicate();
        String certHtml = htmlGenerator.generate(testCertificate).get(1);
        certificatePageObject = new CertificatePageObject(certHtml);
        expectedData = (MotFailCertificateDataWelsh) testCertificate.getData();
    }

    @Test
    public void verifyIssuerInfo() {
        String issuerInfo = certificatePageObject.getIssuerInfo();
        assertEquals(testCertificate.getCertificateIssuerInfoCy(), issuerInfo);
    }
}
