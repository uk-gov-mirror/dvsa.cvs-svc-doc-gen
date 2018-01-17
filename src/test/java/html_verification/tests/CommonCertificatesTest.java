package html_verification.tests;

import html_verification.framework.component.MileageHistoryComponent;
import html_verification.framework.page_object.CertificatePageObject;
import html_verification.model.CertificateInputData;
import html_verification.service.CertificateTestDataProvider;
import html_verification.service.HtmlGenerator;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CommonCertificatesTest {

    @Parameterized.Parameters(name = "{index}: Certificate: {0}")
    public static Collection<Object[]> data() {
        return CertificateTestDataProvider.getCertificatesTestData();
    }

    private HtmlGenerator htmlGenerator;
    private CertificateInputData certificateInputData;
    protected CertificatePageObject certificatePageObject;

    public CommonCertificatesTest(CertificateInputData certificateInputData) {
        this.certificateInputData = certificateInputData;

        this.htmlGenerator = new HtmlGenerator();
    }

    @Before
    public void setup() {
        String certHtml = htmlGenerator.generate(certificateInputData);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verify_Tester_VTS_And_Vehicle_Data() {
        getExpectedValues().forEach(
                (htmlElement, expectedValue) -> {
                    String actualText = certificatePageObject.getTextOf(htmlElement);

                    assertEquals(expectedValue, actualText);
                }
        );
    }

    @Test
    public void verify_DVSA_Logo_Is_Linked() {
        Element dvsaLogoElement = certificatePageObject.getElement(CertificatePageObject.DVSA_LOGO_SELECTOR);

        assertNotNull(dvsaLogoElement);
    }

    @Test
    public void verify_Mileage_History_Entries_Count() {
        MileageHistoryComponent mileageHistoryComponent = certificatePageObject.getMileageHistoryComponent();

        assertTrue(mileageHistoryComponent.getEntries().size() <= 3);
    }

    private Map<String, String> getExpectedValues() {
        Map<String, String> expectedValues = new HashMap<>();

        expectedValues.put(CertificatePageObject.VIN_ID, certificateInputData.getVIN());
        expectedValues.put(CertificatePageObject.REGISTRATION_NUMBER_ID, certificateInputData.getRegistrationNumber());
        expectedValues.put(CertificatePageObject.COUNTRY_ID, certificateInputData.getCountry());
        expectedValues.put(CertificatePageObject.MAKE_AND_MODEL_ID, certificateInputData.getMakeAndModel());
        expectedValues.put(CertificatePageObject.VEHICLE_CATEGORY_ID, certificateInputData.getVehicleCategory());
        expectedValues.put(CertificatePageObject.MILEAGE_ID, certificateInputData.getMileage());
        expectedValues.put(CertificatePageObject.DATE_OF_THE_TEST_ID, certificateInputData.getDateOfTheTest());
        expectedValues.put(CertificatePageObject.EXPIRY_DATE_ID, certificateInputData.getExpiryDate());
        expectedValues.put(CertificatePageObject.LOCATION_OF_THE_TEST_ID, certificateInputData.getLocationOfTheTest());
        expectedValues.put(CertificatePageObject.TESTING_ORG_AND_INSP_NAME_ID, certificateInputData.getTestingOrgAndInspName());
        expectedValues.put(CertificatePageObject.MOT_TEST_NUMBER_ID, certificateInputData.getMotTestNumber());

        return expectedValues;
    }


}
