package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;

public abstract class MotFailCertificate extends MotCertificate {

    @JsonProperty("DATA")
    protected MotFailCertificateData data;

    public MotFailCertificateData getData() {
        return data;
    }

    public MotFailCertificate setData(MotFailCertificateData data) {
        this.data = data;
        return this;
    }
}
