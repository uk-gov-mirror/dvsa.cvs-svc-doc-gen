package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotFailCertificateData extends MotCertificateData {

    @JsonProperty("FailureInformation")
    private String failureInformation;

    @JsonProperty("ReasonForCancel")
    private String reasonForCancel;

    @JsonProperty("ReasonForCancelComment")
    private String reasonForCancelComment;

    public String getFailureInformation() {
        return failureInformation;
    }

    public MotFailCertificateData setFailureInformation(String failureInformation) {
        this.failureInformation = failureInformation;
        return this;
    }

    public String getReasonForCancel() {
        return reasonForCancel;
    }

    public MotFailCertificateData setReasonForCancel(String reasonForCancel) {
        this.reasonForCancel = reasonForCancel;
        return this;
    }

    public String getReasonForCancelComment() {
        return reasonForCancelComment;
    }

    public MotFailCertificateData setReasonForCancelComment(String reasonForCancelComment) {
        this.reasonForCancelComment = reasonForCancelComment;
        return this;
    }
}
