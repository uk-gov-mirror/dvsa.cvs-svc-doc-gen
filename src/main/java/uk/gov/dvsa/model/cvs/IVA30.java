package uk.gov.dvsa.model.cvs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.IvaFailCertificateData;
import uk.gov.dvsa.model.cvs.certificateData.Signature;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IVA30 extends Document {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("Signature")
    private Signature signature;

    @JsonProperty("IVA_DATA")
    private IvaFailCertificateData ivaData;

    public IVA30() {
        // zero value constructor
    }

    public String getId() {
        return id;
    }

    public IVA30 setId(String id) {
        this.id = id;
        return this;
    }

    public IvaFailCertificateData getIvaData() {
        return ivaData;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setIvaData(IvaFailCertificateData ivaData) {
        this.ivaData = ivaData;
    }

    public IVA30 setSignature(Signature signature) {
        this.signature = signature;
        return this;
    }
}
