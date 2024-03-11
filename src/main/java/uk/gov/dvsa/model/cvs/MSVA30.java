package uk.gov.dvsa.model.cvs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.MsvaFailCertificateData;
import uk.gov.dvsa.model.cvs.certificateData.Signature;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MSVA30 extends Document {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("Signature")
    private Signature signature;

    @JsonProperty("MSVA_DATA")
    private MsvaFailCertificateData msvaData;

    public MSVA30 setId(String id) {
        this.id = id;
        return this;
    }
    public String getId(){
        return this.id;
    }

    public Signature getSignature() {
        return signature;
    }

    public MSVA30 setSignature(Signature signature) {
        this.signature = signature;
        return this;
    }
    public void setMsvaData(MsvaFailCertificateData msvaData){
        this.msvaData = msvaData;
    }
    public MsvaFailCertificateData getMsvaData() {
        return this.msvaData;
    }
}

