package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequiredStandard {
    @JsonProperty
    private boolean prs;
    @JsonProperty
    private String requiredStandard;
    @JsonProperty
    private String refCalculation;
    @JsonProperty
    private String sectionNumber;
    @JsonProperty
    private boolean additionalInfo;
    @JsonProperty
    private String sectionDescription;
    @JsonProperty
    private int rsNumber;
    @JsonProperty
    private String[] inspectionTypes;
    @JsonProperty
    private String additionalNotes;

    public RequiredStandard(boolean prs, String requiredStandard, String refCalculation, String sectionNumber, boolean additionalInfo, String sectionDescription, int rsNumber, String[] inspectionTypes, String additionalNotes) {
        this.prs = prs;
        this.requiredStandard = requiredStandard;
        this.refCalculation = refCalculation;
        this.sectionNumber = sectionNumber;
        this.additionalInfo = additionalInfo;
        this.sectionDescription = sectionDescription;
        this.rsNumber = rsNumber;
        this.inspectionTypes = inspectionTypes;
        this.additionalNotes = additionalNotes;
    }

    public RequiredStandard() {
        // zero value constructor
    }

    public boolean getPrs() {
        return prs;
    }

    public void setPrs(boolean prs) {
        this.prs = prs;
    }

    public String getRequiredStandard() {
        return requiredStandard;
    }

    public void setRequiredStandard(String requiredStandard) {
        this.requiredStandard = requiredStandard;
    }

    public String getRefCalculation() {
        return refCalculation;
    }

    public void setRefCalculation(String refCalculation) {
        this.refCalculation = refCalculation;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public boolean getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(boolean additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public int getRsNumber() {
        return rsNumber;
    }

    public void setRsNumber(int rsNumber) {
        this.rsNumber = rsNumber;
    }

    public String[] getInspectionTypes() {
        return inspectionTypes;
    }

    public void setInspectionTypes(String[] inspectionTypes) {
        this.inspectionTypes = inspectionTypes;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
