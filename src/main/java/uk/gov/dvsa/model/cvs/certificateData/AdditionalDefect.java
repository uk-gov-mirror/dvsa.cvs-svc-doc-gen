package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalDefect {
    @JsonProperty("defectName")
    private String defectName;
    @JsonProperty("defectNotes")
    private String defectNotes;

    public AdditionalDefect(String defectName, String defectNotes) {
        this.defectName = defectName;
        this.defectNotes = defectNotes;
    }

    public AdditionalDefect() {
        // zero value constructor
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public String getDefectNotes() {
        return defectNotes;
    }

    public void setDefectNotes(String defectNotes) {
        this.defectNotes = defectNotes;
    }
}
