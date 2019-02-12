package uk.gov.dvsa.model.cvs;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.cvs.certificateData.CvsMotFailCertificateData;

public abstract class CvsMotFailCertificate extends CvsMotCertificate {

    @JsonProperty("FAIL_DATA")
    protected CvsMotFailCertificateData failData;

    public CvsMotFailCertificateData getFailData() {
        return failData;
    }

    public CvsMotFailCertificate setFailData(CvsMotFailCertificateData failData) {
        this.failData = failData;
        return this;
    }
}
