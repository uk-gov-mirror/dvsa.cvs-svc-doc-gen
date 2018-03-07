package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.framework.page_object.CertificatePageSelector;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.mot.MotCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class WatermarkTest {
    private HtmlGenerator htmlGenerator;
    private MotCertificate testCertificate;


    private final String watermarkSelector = CertificatePageSelector.WATERMARK_SELECTOR.getSelector();
    private final String watermarkText = "NOT VALID";

    @Parameterized.Parameters(name = "{index}: Certificate: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { CertificateTestDataProvider.getVt20() },
                { CertificateTestDataProvider.getVt20W() },
                { CertificateTestDataProvider.getVt30() },
                { CertificateTestDataProvider.getVt30W() },
        });
    }

    public WatermarkTest(MotCertificate testCertificate) {
        this.testCertificate = testCertificate;

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Test
    public void verifyWatermarkExists() throws IOException {
        List<CertificatePageObject> certs = generateCerts(this.testCertificate, true);

        certs.forEach(cert -> assertEquals(cert.getWatermark().text(), this.watermarkText));
    }

    @Test
    public void verifyWatermarkDoesNotExist() throws IOException {
        List<CertificatePageObject> certs = generateCerts(this.testCertificate, false);

        certs.forEach(cert -> assertFalse(cert.elementExists(watermarkSelector)));
    }

    private List<CertificatePageObject> generateCerts(MotCertificate testCertificate, boolean withWatermark) throws IOException {
        if(withWatermark) {
            testCertificate.setWatermark(this.watermarkText);
        }

        return htmlGenerator.generate(testCertificate).stream().map(html -> new CertificatePageObject(html)).collect(Collectors.toList());
    }
}
