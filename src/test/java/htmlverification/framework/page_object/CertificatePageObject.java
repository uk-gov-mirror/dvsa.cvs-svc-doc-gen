package htmlverification.framework.page_object;

import htmlverification.framework.component.DefectSummaryComponent;
import htmlverification.framework.component.MileageHistoryComponent;
import org.jsoup.nodes.Element;

import static htmlverification.framework.page_object.CertificatePageSelector.*;

public class CertificatePageObject extends BasePageObject {

    public CertificatePageObject(String htmlContent) {
        super(htmlContent);
    }

    public MileageHistoryComponent getMileageHistoryComponent() {
        Element mileageHistoryElement = getElementById(CertificatePageSelector.MILEAGE_HISTORY_ID.getSelector());

        return new MileageHistoryComponent(mileageHistoryElement);
    }

    public DefectSummaryComponent getDefectSummaryComponent() {
        Element defectSummaryElement = getElement("." + RESULTS_SUMMARY_CLASS.getSelector());

        return new DefectSummaryComponent(defectSummaryElement);
    }

    public String getVin() {
        return getElementById(VIN_ID.getSelector()).text();
    }

    public String getCountryOfRegistration() {
        return getElementById(COUNTRY_ID.getSelector()).text();
    }

    public String getMakeAndModel() {
        return getElementById(MAKE_AND_MODEL_ID.getSelector()).text();
    }

    public String getVehicleCategory() {
        return getElementById(VEHICLE_CATEGORY_ID.getSelector()).text();
    }

    public String getMileage() {
        return getElementById(MILEAGE_ID.getSelector()).text();
    }

    public String getDateOfTheTest() {
        return getElementById(DATE_OF_THE_TEST_ID.getSelector()).text();
    }

    public String getExpiryDate() {
        return getElementById(EXPIRY_DATE_ID.getSelector()).text();
    }

    public String getLocationOfTheTest() {
        return getElementById(LOCATION_OF_THE_TEST_ID.getSelector()).text();
    }

    public String getTestingOrganisationAndInspectorsName() {
        return getElementById(TESTING_ORG_AND_INSP_NAME_ID.getSelector()).text();
    }

    public String getTestNumber() {
        return getElementById(MOT_TEST_NUMBER_ID.getSelector()).text();
    }

    public String getIssuerInfo() {
        return getElementById(ISSUER_INFO_ID.getSelector()).text();
    }
}
