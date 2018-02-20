package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Vt20DuplicateTest extends Vt20Test {

    public Vt20DuplicateTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt20Duplicate();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyIssuerInfo() {
        String issuerInfo = certificatePageObject.getIssuerInfo();
        assertEquals(testCertificate.getCertificateIssuerInfo(), issuerInfo);
    }

}
