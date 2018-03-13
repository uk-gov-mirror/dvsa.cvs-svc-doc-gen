package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;

public class VT30W extends MotFailCertificate {

    @JsonProperty("FAIL_DATA")
    protected MotFailCertificateDataWelsh failData;

    public MotFailCertificateDataWelsh getFailData() {
        return failData;
    }

    public VT30W setFailData (MotFailCertificateDataWelsh data) {
        this.failData = data;
        return this;
    }
}
