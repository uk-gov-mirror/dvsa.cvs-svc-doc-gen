package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public abstract class ContingencyCertificate extends Document {

    @JsonProperty("InspectionAuthority")
    private String inspectionAuthority;

    @JsonProperty("Vts")
    private String vts;

    public String getInspectionAuthority() {
        return inspectionAuthority;
    }

    public ContingencyCertificate setInspectionAuthority(String inspectionAuthority) {
        this.inspectionAuthority = inspectionAuthority;
        return this;
    }

    public String getVts() {
        return vts;
    }

    public ContingencyCertificate setVts(String vts) {
        this.vts = vts;
        return this;
    }
}
