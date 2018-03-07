package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.component.DefectSummaryComponent;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.mot.MotFailCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Vt30RefusalTest {

    private HtmlGenerator htmlGenerator;
    private MotFailCertificate testCertificate;
    private CertificatePageObject certificatePageObject;

    public Vt30RefusalTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getVt30Refusal();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyReasonForCancel() {
        DefectSummaryComponent summary = certificatePageObject.getDefectSummaryComponent();
        Elements reasonForCancelComponent = summary.getByTitle(testCertificate.getFailData().getReasonForCancelEn());
        List<String> texts = reasonForCancelComponent.eachText();
        assertEquals(1, texts.size());
        assertEquals(testCertificate.getFailData().getReasonForCancelComment(), texts.get(0));
    }
}
