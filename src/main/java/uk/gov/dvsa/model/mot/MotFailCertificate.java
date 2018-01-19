package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MotFailCertificate extends MotCertificate {

     @JsonProperty("DATA")
    private MotFailCertificateData data;

    public MotFailCertificateData getData() {
        return data;
    }

    public MotFailCertificate setData(MotFailCertificateData data) {
        this.data = data;
        return this;
    }
}
