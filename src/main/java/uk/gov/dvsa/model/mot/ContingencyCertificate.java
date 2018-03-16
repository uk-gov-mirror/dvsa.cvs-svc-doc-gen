package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jknack.handlebars.Handlebars;
import uk.gov.dvsa.model.Document;

import java.util.List;
import java.util.stream.Collectors;

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
        return inspectionAuthority.stream()
                .map(inspAuthLine -> (String) Handlebars.Utils.escapeExpression(inspAuthLine))
                .collect(Collectors.toList());
    }

    public ContingencyCertificate setInspectionAuthority(List<String> inspectionAuthority) {
        this.inspectionAuthority = inspectionAuthority;
        return this;
    }
}
