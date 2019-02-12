package htmlverification.framework.page_object;

public enum CertificatePageSelector {
    MAKE_AND_MODEL_ID("make-model"),
    MAKE_ID("make"),
    MODEL_ID("model"),
    DATE_OF_THE_TEST_ID("date-of-test"),
    VIN_ID("vin"),
    REGISTRATION_NUMBER_ID("reg-number"),
    COUNTRY_ID("country"),
    VEHICLE_CATEGORY_ID("vehicle-category"),
    MILEAGE_ID("mileage"),
    MILEAGE_HISTORY_ID("mileage-history"),
    LOCATION_OF_THE_TEST_ID("location-of-test"),
    TESTING_ORG_AND_INSP_NAME_ID("organisation-and-inspection-name"),
    INSPECTION_AUTHORITY("inspection-authority"),
    MOT_TEST_NUMBER_ID("mot-test-number"),
    TEST_STATION_ID("test-station-id"),
    RESULTS_SUMMARY_CLASS("results"),
    DVSA_LOGO_ID("logo"),
    EXPIRY_DATE_ID("expiry-date"),
    ISSUER_INFO_ID("issuer-info"),
    ISSUED_DATE_ID("issued-date"),
    DVSA_LOGO_WELSH_ID("logo-welsh"),
    EARLIEST_DATE_OF_THE_NEXT_TEST("earliest-preserve-date"),
    WATERMARK_SELECTOR("span.running-header__text"),
    DEFECTS_ID("defects"),

    CVS_SIGNATURE_FIRST_PAGE("signature-first-page"),
    CVS_SIGNATURE_SECOND_PAGE("signature-second-page");

    private final String selector;

    CertificatePageSelector(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
