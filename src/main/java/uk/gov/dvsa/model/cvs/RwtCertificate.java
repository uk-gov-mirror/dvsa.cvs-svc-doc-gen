package uk.gov.dvsa.model.cvs;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.RwtCertificateData;
import uk.gov.dvsa.model.cvs.certificateData.Signature;

public class RwtCertificate extends Document {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("Signature")
    private Signature signature;

    @JsonProperty("RWT_DATA")
    protected RwtCertificateData rwtData;

    public String getId() {
        return id;
    }

    public RwtCertificate setId(String id) {
        this.id = id;
        return this;
    }

    public RwtCertificateData getRwtData() {
        return rwtData;
    }

    public Document setRwtData(RwtCertificateData rwtData) {
        this.rwtData = rwtData;
        return this;
    }

    public Signature getSignature() {
        return signature;
    }

    public RwtCertificate setSignature(Signature signature) {
        this.signature = signature;
        return this;
    }
}