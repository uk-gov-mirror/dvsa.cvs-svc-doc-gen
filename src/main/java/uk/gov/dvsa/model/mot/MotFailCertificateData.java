package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.reasonforrejection.DangerousDefects;
import uk.gov.dvsa.model.mot.reasonforrejection.FailedSummaryHeader;
import uk.gov.dvsa.model.mot.reasonforrejection.ReasonsForRejectionGroup;

import java.util.List;

public class MotFailCertificateData extends MotCertificateData {

    @JsonProperty("FailureInformation")
    private String failureInformation;

    @JsonProperty("ReasonForCancel")
    private String reasonForCancel;

    @JsonProperty("ReasonForCancelComment")
    private String reasonForCancelComment;

    @JsonProperty("EuDangerousDefects")
    private List<String> euDangerousDefects;

    public MotFailCertificateData() {
        results.add(new FailedSummaryHeader());
    }

    public MotFailCertificateData setFailureInformation(String failureInformation) {
        this.failureInformation = failureInformation;
        return this;
    }

    public MotFailCertificateData setEuDangerousDefects(List<String> euDangerousDefects) {
        super.results.add(new DangerousDefects(euDangerousDefects));
        this.euDangerousDefects = euDangerousDefects;
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

    @Override
    public List<ReasonsForRejectionGroup> getResults() {
        return super.getResults();
    }
}
