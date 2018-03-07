package uk.gov.dvsa.model.mot.enums;

public enum CertificateTypes {

    PASS("MOT/VT20"),
    FAIL("MOT/VT30"),
    WELSH_PASS("MOT/VT20W"),
    WELSH_FAIL("MOT/VT30W"),
    PRS("MOT/PRS"),
    WELSH_PRS("MOT/PRSW"),

    EU_CONTINGENCY_PASS("MOT/EU_CT20"),
    EU_CONTINGENCY_FAIL("MOT/EU_CT30"),

    CONTINGENCY_PASS("MOT/CT20"),
    CONTINGENCY_FAIL("MOT/CT30"),
    CONTINGENCY_ADVISORY_NOTICE("MOT/CT32");

    private final String type;

    CertificateTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
