package uk.gov.dvsa.model.mot.enums;

public enum CertificateTemplates {

    EU_CT20("MOT/EU_CT20"),
    EU_CT30("MOT/EU_CT30"),

    CT20("MOT/CT20"),
    CT30("MOT/CT30"),
    CT32("MOT/CT32"),

    VT30("MOT/VT30"),
    VT20("MOT/VT20"),
    VT20W("MOT/VT20W"),
    VT30W("MOT/VT30W");

    private final String certificateTemplateName;

    CertificateTemplates(String certificateTemplateName) {
        this.certificateTemplateName = certificateTemplateName;
    }

    public String getCertificateTemplateName() {
        return certificateTemplateName;
    }
}
