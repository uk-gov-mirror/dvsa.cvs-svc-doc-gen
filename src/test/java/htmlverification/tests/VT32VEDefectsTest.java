package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import com.lowagie.text.DocumentException;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import junit.framework.TestCase;
import org.junit.Test;
import uk.gov.dvsa.model.mot.VT32VE;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;
import uk.gov.dvsa.model.mot.enums.Vt32defectsConfig;
import uk.gov.dvsa.service.VT32VEHtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VT32VEDefectsTest {

    private VT32VEHtmlGenerator htmlGenerator;

    public VT32VEDefectsTest() {
        this.htmlGenerator = new VT32VEHtmlGenerator(new Handlebars());
    }

    @Test
    public void verifyPostEuDefects() throws IOException, DocumentException  {
        VT32VE testCertificate = CertificateTestDataProvider.getEuVt32Ve();
        MotFailCertificateData expectedData = testCertificate.getFailData();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        CertificatePageObject certificatePageObject = new CertificatePageObject(certHtml);

        String defects = certificatePageObject.getDefects();

        assertTrue(defects.contains(Vt32defectsConfig.ADVISORY_DEFECTS.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.DANGEROUS_DEFECTS.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.MAJOR_DEFECTS.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.MINOR_DEFECTS.getHeaderText()));

        assertFalse(defects.contains(Vt32defectsConfig.PRE_EU_ADVISORIES.getHeaderText()));
        assertFalse(defects.contains(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS.getHeaderText()));

        assertTrue(defects.contains(expectedData.getEuDangerousDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuMajorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuMinorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuAdvisoryDefects().get(0)));
    }

    @Test
    public void verifyPostEuWelshDefects() throws IOException, DocumentException {
        VT32VE testCertificate = CertificateTestDataProvider.getEuVt32VeW();
        MotFailCertificateData expectedData = testCertificate.getFailData();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        CertificatePageObject certificatePageObject = new CertificatePageObject(certHtml);

        String defects = certificatePageObject.getDefects();

        assertTrue(defects.contains(Vt32defectsConfig.ADVISORY_DEFECTS_WELSH.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.DANGEROUS_DEFECTS_WELSH.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.MAJOR_DEFECTS_WELSH.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.MINOR_DEFECTS_WELSH.getHeaderText()));

        assertFalse(defects.contains(Vt32defectsConfig.PRE_EU_ADVISORIES_WELSH.getHeaderText()));
        assertFalse(defects.contains(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS_WELSH.getHeaderText()));

        assertTrue(defects.contains(expectedData.getEuDangerousDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuMajorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuMinorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuAdvisoryDefects().get(0)));
    }

    @Test
    public void verifyPreEuDefects() throws IOException, DocumentException {
        VT32VE testCertificate = CertificateTestDataProvider.getVt32Ve();
        MotFailCertificateData expectedData = testCertificate.getFailData();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        CertificatePageObject certificatePageObject = new CertificatePageObject(certHtml);

        String defects = certificatePageObject.getDefects();

        assertTrue(defects.contains(Vt32defectsConfig.PRE_EU_ADVISORIES.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS.getHeaderText()));

        assertTrue(defects.contains(expectedData.getEuMajorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuAdvisoryDefects().get(0)));

        TestCase.assertFalse(defects.contains(expectedData.getEuMinorDefects().get(0)));
        TestCase.assertFalse(defects.contains(expectedData.getEuDangerousDefects().get(0)));
    }

    @Test
    public void verifyPreEuWelshDefects() throws IOException, DocumentException {
        VT32VE testCertificate = CertificateTestDataProvider.getVt32VeW();
        MotFailCertificateData expectedData = testCertificate.getFailData();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        CertificatePageObject certificatePageObject = new CertificatePageObject(certHtml);

        String defects = certificatePageObject.getDefects();

        assertTrue(defects.contains(Vt32defectsConfig.PRE_EU_ADVISORIES_WELSH.getHeaderText()));
        assertTrue(defects.contains(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS_WELSH.getHeaderText()));

        assertTrue(defects.contains(expectedData.getEuMajorDefects().get(0)));
        assertTrue(defects.contains(expectedData.getEuAdvisoryDefects().get(0)));

        TestCase.assertFalse(defects.contains(expectedData.getEuMinorDefects().get(0)));
        TestCase.assertFalse(defects.contains(expectedData.getEuDangerousDefects().get(0)));
    }
}
