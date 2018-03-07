package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;

public abstract class MotFailCertificate extends MotCertificate {

    @JsonProperty("FAIL_DATA")
    protected MotFailCertificateData failData;

    public MotFailCertificateData getFailData() {
        return failData;
    }

    public MotFailCertificate setFailData(MotFailCertificateData data) {
        this.failData = data;
        return this;
    }
}
