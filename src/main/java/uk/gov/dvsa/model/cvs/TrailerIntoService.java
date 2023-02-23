package uk.gov.dvsa.model.cvs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.ApplicantDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrailerIntoService extends Document {

    @JsonProperty("applicantDetails")
    private ApplicantDetails applicantDetails;

    @JsonProperty("letterDateRequested")
    private String letterDateRequested;

    @JsonProperty("vin")
    private String vin;

    @JsonProperty("trailerId")
    private String trailerId;

    @JsonProperty("approvalTypeNumber")
    private String approvalTypeNumber;

    @JsonProperty("paragraphId")
    private int paragraphId;

    public ApplicantDetails getApplicantDetails() {
        return applicantDetails;
    }
    public TrailerIntoService setApplicantDetails(ApplicantDetails applicantDetails) {
        this.applicantDetails = applicantDetails;
        return this;
    }

    public String getLetterDateRequested() { return this.letterDateRequested; }
    public TrailerIntoService setLetterDateRequested(String letterDateRequested) {
        this.letterDateRequested = letterDateRequested;
        return this;
    }

    public String getVin() { return vin; }
    public TrailerIntoService setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getTrailerId() { return trailerId; }
    public TrailerIntoService setTrailerId(String trailerId) {
        this.trailerId = trailerId;
        return this;
    }

    public String getApprovalTypeNumber() { return approvalTypeNumber; }
    public TrailerIntoService setApprovalTypeNumber(String approvalTypeNumber) {
        this.approvalTypeNumber = approvalTypeNumber;
        return this;
    }

    public int getParagraphId() { return this.paragraphId; }
    public TrailerIntoService setParagraphId(int paragraphId) {
        this.paragraphId = paragraphId;
        return this;
    }
}
