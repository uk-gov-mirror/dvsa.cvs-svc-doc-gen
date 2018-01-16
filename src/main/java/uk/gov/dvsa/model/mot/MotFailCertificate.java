package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public abstract class MotFailCertificate extends Document {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("IssuerInfo")
    private String issuerInfo;

    @JsonProperty("DATA")
    private MotFailCertificateData data;

    public String getId() {
        return id;
    }

    public MotFailCertificate setId(String id) {
        this.id = id;
        return this;
    }

    public String getIssuerInfo() {
        return issuerInfo;
    }

    public MotFailCertificate setIssuerInfo(String issuerInfo) {
        this.issuerInfo = issuerInfo;
        return this;
    }

    public MotFailCertificateData getData() {
        return data;
    }

    public MotFailCertificate setData(MotFailCertificateData data) {
        this.data = data;
        return this;
    }
}
