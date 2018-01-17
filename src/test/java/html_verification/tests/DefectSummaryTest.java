package html_verification.tests;

import html_verification.framework.page_object.CertificatePageObject;
import html_verification.model.CertificateInputData;
import html_verification.service.CertificateTestDataProvider;
import html_verification.service.HtmlGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefectSummaryTest {

    protected HtmlGenerator htmlGenerator;
    protected CertificateInputData certificateInputData;
    protected CertificatePageObject certificatePageObject;

    public DefectSummaryTest() {
        this.htmlGenerator = new HtmlGenerator();
    }

    @Before
    public void setup() {
        certificateInputData = CertificateTestDataProvider.VT20;
        String certHtml = htmlGenerator.generate(certificateInputData);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verify_Result_Name() {
        String resultName = certificatePageObject.getDefectSummaryComponent().getResultNameItem().text();

        assertEquals("7 Pass with defects", resultName);
    }

    @Test
    public void verify_Advisories() {
        List<String> advisories = certificatePageObject.getDefectSummaryComponent().getAdvisories().eachText();

        assertEquals(3, advisories.size());
    }
    @Test
    public void verify_Minor_Defects() {
        List<String> minorDefects = certificatePageObject.getDefectSummaryComponent().getMinorDefects().eachText();

        assertEquals(20, minorDefects.size());
    }
}
