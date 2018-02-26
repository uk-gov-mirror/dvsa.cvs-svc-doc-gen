package uk.gov.dvsa.model.mot.enums;

public enum CertificateTemplates {

    VT30("MOT/VT30"),
    VT20("MOT/VT20"),
    VT20W("MOT/VT20W"),
    VT30W("MOT/VT30W");


    private final String certificateName;

    CertificateTemplates(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateName() {
        return certificateName;
    }
}
