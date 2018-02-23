package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

import java.util.List;

public abstract class ContingencyCertificate extends Document {

    @JsonProperty("InspectionAuthority")
    private List<String> inspectionAuthority;

    @JsonProperty("Vts")
    private String vts;

    public String getVts() {
        return vts;
    }

    public ContingencyCertificate setVts(String vts) {
        this.vts = vts;
        return this;
    }

    public List<String> getInspectionAuthority() {
        return inspectionAuthority;
    }

    public ContingencyCertificate setInspectionAuthority(List<String> inspectionAuthority) {
        this.inspectionAuthority = inspectionAuthority;
        return this;
    }
}
