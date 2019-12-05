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

    public String getInspectionAuthority() {
        return getElementById(INSPECTION_AUTHORITY.getSelector()).text();
    }

    public String getTestingOrganisationAndInspectorsName() {
        return getElementById(TESTING_ORG_AND_INSP_NAME_ID.getSelector()).text();
    }

    public String getTestStationId() {
        return getElementById(TEST_STATION_ID.getSelector()).text();
    }

    public String getTestNumber() {
        return getElementById(MOT_TEST_NUMBER_ID.getSelector()).text();
    }

    public String getIssuerInfo() {
        return getElementById(ISSUER_INFO_ID.getSelector()).text();
    }

    public String getEarliestDateOfTheNextTest() {
        return getElementById(EARLIEST_DATE_OF_THE_NEXT_TEST.getSelector()).text();
    }

    public Element getWatermark() {
        return getElement(WATERMARK_SELECTOR.getSelector());
    }

    public String getRegistrationNumber() {
        return getElementById(REGISTRATION_NUMBER_ID.getSelector()).text();
    }

    public String getMake() {
        return getElementById(MAKE_ID.getSelector()).text();
    }

    public String getModel() {
        return getElementById(MODEL_ID.getSelector()).text();
    }

    public String getIssuedDate() {
        return getElementById(ISSUED_DATE_ID.getSelector()).text();
    }

    public Element getLogo() {
        return getElementById(DVSA_LOGO_ID.getSelector());
    }

    public Element getWelshLogo() {
        return getElementById(DVSA_LOGO_WELSH_ID.getSelector());
    }

    public String getDefects() {
        return getElementById(DEFECTS_ID.getSelector()).text();
    }

    public String getSignatureImageSrc() {
        return getElementById(CVS_SIGNATURE_FIRST_PAGE.getSelector()).attr("src");
    }

    public String getDgvw() {return  getElementById(DGVW.getSelector()).text();}
    public String getWeight2() {return getElementById(WEIGHT2.getSelector()).text();}
    public String getVehicleNumber() {return getElementById(VEHICLE_NUMBER.getSelector()).text();}
    public String getIssuersName() {return getElementById(ISSUERS_NAME.getSelector()).text();}
    public String getDateOfInspection() {return getElementById(DATE_OF_INSPECTION.getSelector()).text();}
    public String getTestStationPNumber() {return getElementById(TEST_STATION_PNUMBER.getSelector()).text();}
    public String getDocumentNumber() {return getElementById(DOCUMENT_NUMBER.getSelector()).text();}
    public String getRwtDate() {return getElementById(RWT_DATE.getSelector()).text();}
    public String getRwtMonth() {return getElementById(RWT_MONTH.getSelector()).text();}
    public String getRwtYear() {return getElementById(RWT_YEAR.getSelector()).text();}
    public String getRwtDefect(int id){
        switch (id){
            case 0:
                return getElementById(RWT_DEFECTS_FIRST.getSelector()).text();
            case 1:
                 return getElementById(RWT_DEFECTS_SECOND.getSelector()).text();
            case 2:
                return getElementById(RWT_DEFECTS_THIRD.getSelector()).text();
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }
    public String getDocumentNumberFooter() {return getElementById(DOCUMENT_NUMBER_FOOTER.getSelector()).text();}
}
