package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Test;
import uk.gov.dvsa.model.mot.ContingencyCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ContingencyCertificatesTest {

    protected HtmlGenerator htmlGenerator;

    public ContingencyCertificatesTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Test
    public void verifyCt20() throws IOException {
        CertificatePageObject ct20 = getCertificatePageObject(CertificateTestDataProvider.getCt20());

        verifyTestStationId(ct20);
        verifyInspectionAuthority(ct20);
    }

    @Test
    public void verifyCt30() throws IOException {
        CertificatePageObject ct30 = getCertificatePageObject(CertificateTestDataProvider.getCt30());

        verifyTestStationId(ct30);
        verifyInspectionAuthority(ct30);
    }

    @Test
    public void verifyCt32() throws IOException {
        CertificatePageObject ct32 = getCertificatePageObject(CertificateTestDataProvider.getCt32());

        verifyTestStationId(ct32);
        verifyInspectionAuthority(ct32);
    }

    @Test
    public void verifyEuCt20() throws IOException {
        CertificatePageObject euCt20 = getCertificatePageObject(CertificateTestDataProvider.getEuCt20());

        verifyTestStationId(euCt20);
        verifyInspectionAuthority(euCt20);
    }

    @Test
    public void verifyEuCt30() throws IOException {
        CertificatePageObject euCt30 = getCertificatePageObject(CertificateTestDataProvider.getEuCt30());

        verifyTestStationId(euCt30);
        verifyInspectionAuthority(euCt30);
    }

    private CertificatePageObject getCertificatePageObject(ContingencyCertificate certificate) throws IOException {
        ContingencyCertificate certificateData = CertificateTestDataProvider.getEuCt30();
        String certificateHtml = htmlGenerator.generate(certificateData).get(0);
        return new CertificatePageObject(certificateHtml);
    }

    private void verifyTestStationId(CertificatePageObject certificatePageObject) {
        String testStationId = certificatePageObject.getTestStationId();
        assertEquals(CertificateTestDataProvider.VTS_ID, testStationId);
    }

    public void verifyInspectionAuthority(CertificatePageObject certificatePageObject) {
        String inspectionAuthority = certificatePageObject.getInspectionAuthority();
        assertEquals("Welsh Garage 1 Welsh Road Swansea SW1 1NT\\t\\t+768-45-4433630", inspectionAuthority);
    }


}
