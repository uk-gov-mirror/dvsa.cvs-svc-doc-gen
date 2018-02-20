package uk.gov.dvsa.model.mot.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.results.DefectsList;
import uk.gov.dvsa.model.mot.results.Summary;

import java.util.List;

public class MotFailCertificateData extends MotCertificateData {

    public static final String FAILED_SUMMARY_HEADER = "Fail"; // header displayed above other lists of RFRs
    private static final String DANGEROUS_DEFECTS_HEADER = "Do not drive until repaired (dangerous defects)";
    private static final String MAJOR_DEFECTS_HEADER = "Repair immediately (major defects)";

    public List<String> getNoticeInformationOnRejection() {
        return noticeInformationOnRejection;
    }

    @JsonProperty("FailureInformation")
    private String failureInformation;

    @JsonProperty("ReasonForCancel")
    private String reasonForCancel;

    @JsonProperty("ReasonForCancelComment")
    private String reasonForCancelComment;

    @JsonProperty("DangerousDefectsHeader")
    private String dangerousDefectsHeader;

    @JsonProperty("MajorDefectsHeader")
    private String majorDefectsHeader;

    @JsonProperty("NoticeInformationOnRejection")
    private List<String> noticeInformationOnRejection;

    @JsonProperty("DangerousDefects")
    private String oldDangerousDefects;

    @JsonProperty("MajorDefects")
    private String oldMajorDefects;

    @JsonProperty("EuDangerousDefects")
    private List<String> euDangerousDefects;

    @JsonProperty("EuMajorDefects")
    private List<String> euMajorDefects;

    public MotFailCertificateData setFailureInformation(String failureInformation) {
        this.failureInformation = failureInformation;
        return this;
    }

    public MotFailCertificateData setEuDangerousDefects(List<String> euDangerousDefects) {
        this.euDangerousDefects = euDangerousDefects;
        return this;
    }

    public MotFailCertificateData setEuMajorDefects(List<String> euMajorDefects) {
        this.euMajorDefects = euMajorDefects;
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

    public String getDangerousDefectsHeader() {
        return dangerousDefectsHeader;
    }

    public MotFailCertificateData setDangerousDefectsHeader(String dangerousDefectsHeader) {
        this.dangerousDefectsHeader = dangerousDefectsHeader;
        return this;
    }

    public String getMajorDefectsHeader() {
        return majorDefectsHeader;
    }

    public MotFailCertificateData setMajorDefectsHeader(String majorDefectsHeader) {
        this.majorDefectsHeader = majorDefectsHeader;
        return this;
    }

    public MotFailCertificateData setOldDangerousDefects(String oldDangerousDefects) {
        this.oldDangerousDefects = oldDangerousDefects;
        return this;
    }

    public MotFailCertificateData setOldMajorDefects(String oldMajorDefects) {
        this.oldMajorDefects = oldMajorDefects;
        return this;
    }

    public DefectsList getMajor() {
        return new DefectsList(MAJOR_DEFECTS_HEADER, this.euMajorDefects, EU_NUMBER_FOR_DEFECTS);
    }

    public DefectsList getDangerous() {
        DefectsList dangerousDefects = new DefectsList(DANGEROUS_DEFECTS_HEADER, this.euDangerousDefects, EU_NUMBER_FOR_DEFECTS);
        return dangerousDefects.setIsDangerous(true);
    }

    public Summary getSummary() {
        return new Summary(FAILED_SUMMARY_HEADER);
    }
}
