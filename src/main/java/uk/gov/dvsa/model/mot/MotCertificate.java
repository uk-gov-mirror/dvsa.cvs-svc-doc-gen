package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public abstract class MotCertificate extends Document {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("IssuerInfo")
    private String issuerInfo;

    @JsonProperty("DATA")
    protected MotCertificateData data;

    public String getId() {
        return id;
    }

    public MotCertificate setId(String id) {
        this.id = id;
        return this;
    }

    public String getIssuerInfo() {
        return issuerInfo;
    }

    public MotCertificate setIssuerInfo(String issuerInfo) {
        this.issuerInfo = issuerInfo;
        return this;
    }

    public MotCertificateData getData() {
        return data;
    }

    public Document setData(MotCertificateData data) {
        this.data = data;
        return this;
    }
}
