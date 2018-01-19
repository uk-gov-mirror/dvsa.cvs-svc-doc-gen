package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.component.MileageHistoryComponent;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.framework.page_object.CertificatePageSelector;
import htmlverification.service.CertificateTestDataProvider;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.mot.MotCertificate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;
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
    private MotCertificate testCertificate;
    private CertificatePageObject certificatePageObject;

    public CommonCertificatesTest(MotCertificate testCertificate) {
        this.testCertificate = testCertificate;

        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        String certHtml = htmlGenerator.generate(testCertificate);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyTesterVTSAndVehicleData() {
        getExpectedValues().forEach(
                (htmlElement, expectedValue) -> {
                    String actualText = certificatePageObject.getTextOf(htmlElement);

                    assertEquals(expectedValue, actualText);
                }
        );
    }

    @Test
    @Ignore("Skipping test. Logo needs to be added in a story related to a particular certificate")
    public void verifyDVSALogoIsLinked() {
        Element dvsaLogoElement = certificatePageObject.getElement(CertificatePageSelector.DVSA_LOGO_SELECTOR.getSelector());

        assertNotNull(dvsaLogoElement);
    }

    @Test
    public void verifyMileageHistoryEntriesCount() {
        MileageHistoryComponent mileageHistoryComponent = certificatePageObject.getMileageHistoryComponent();

        assertTrue(mileageHistoryComponent.getEntries().size() <= 3);
    }

    private Map<String, String> getExpectedValues() {
        Map<String, String> expectedValues = new HashMap<>();

        expectedValues.put(CertificatePageSelector.VIN_ID.getSelector(), testCertificate.getData().getVin());
        expectedValues.put(CertificatePageSelector.REGISTRATION_NUMBER_ID.getSelector(), testCertificate.getData().getVrm());
        expectedValues.put(CertificatePageSelector.COUNTRY_ID.getSelector(), testCertificate.getData().getCountryOfRegistration());
        expectedValues.put(CertificatePageSelector.MAKE_AND_MODEL_ID.getSelector(), testCertificate.getData().getMake());
        expectedValues.put(
            CertificatePageSelector.MAKE_AND_MODEL_ID.getSelector(),
            String.format("%s %s", testCertificate.getData().getMake(), testCertificate.getData().getModel())
        );
        expectedValues.put(CertificatePageSelector.VEHICLE_CATEGORY_ID.getSelector(), testCertificate.getData().getTestClass());
        expectedValues.put(CertificatePageSelector.MILEAGE_ID.getSelector(), testCertificate.getData().getOdometer());
        expectedValues.put(CertificatePageSelector.DATE_OF_THE_TEST_ID.getSelector(), testCertificate.getData().getIssuedDate());
        expectedValues.put(CertificatePageSelector.LOCATION_OF_THE_TEST_ID.getSelector(), testCertificate.getData().getTestStationAddress());
        expectedValues.put(CertificatePageSelector.TESTING_ORG_AND_INSP_NAME_ID.getSelector(), testCertificate.getData().getInspectionAuthority());
        expectedValues.put(CertificatePageSelector.MOT_TEST_NUMBER_ID.getSelector(), testCertificate.getData().getTestNumber());

        return expectedValues;
    }


}
