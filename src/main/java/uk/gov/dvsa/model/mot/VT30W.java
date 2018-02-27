package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;

public class VT30W extends MotFailCertificate {

    @JsonProperty("DATA")
    protected MotFailCertificateDataWelsh data;

    public VT30W setData(MotFailCertificateDataWelsh data) {
        this.data = data;
        super.setData(data);
        return this;
    }

    @Override
    public MotFailCertificateDataWelsh getData() {
        return data;
    }
}
