package html_verification.framework.page_object;

import html_verification.framework.component.DefectSummaryComponent;
import html_verification.framework.component.MileageHistoryComponent;
import org.jsoup.nodes.Element;

public class CertificatePageObject extends BasePageObject {

    public static final String MAKE_AND_MODEL_ID = "make-model";
    public static final String DATE_OF_THE_TEST_ID = "date-of-test";
    public static final String VIN_ID = "vin";
    public static final String REGISTRATION_NUMBER_ID = "reg-number";
    public static final String COUNTRY_ID = "country";
    public static final String VEHICLE_CATEGORY_ID = "vehicle-category";
    public static final String MILEAGE_ID = "mileage";
    public static final String MILEAGE_HISTORY_ID = "mileage-history";
    public static final String EXPIRY_DATE_ID = "expiry-date";
    public static final String LOCATION_OF_THE_TEST_ID = "location-of-test";
    public static final String TESTING_ORG_AND_INSP_NAME_ID = "organisation-and-inspection-name";
    public static final String MOT_TEST_NUMBER_ID = "mot-test-number";
    public static final String RESULTS_SUMMARY_CLASS = "results";
    public static final String DVSA_LOGO_SELECTOR = "img[src*=dvsa_crest.png]";

    public CertificatePageObject(String htmlContent) {
        super(htmlContent);
    }

    public MileageHistoryComponent getMileageHistoryComponent() {
        Element mileageHistoryElement = getElementById(MILEAGE_HISTORY_ID);

        return new MileageHistoryComponent(mileageHistoryElement);
    }

    public DefectSummaryComponent getDefectSummaryComponent() {
        Element defectSummaryElement = getElement("." + RESULTS_SUMMARY_CLASS);

        return new DefectSummaryComponent(defectSummaryElement);
    }

}
