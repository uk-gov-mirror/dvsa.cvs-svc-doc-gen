package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.results.DefectsList;
import uk.gov.dvsa.model.mot.results.DefectsListsGrouped;

import java.util.List;

import static uk.gov.dvsa.model.mot.results.Summary.EU_NUMBER_SUMMARY_HEADER;

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

    public MotFailCertificateData() {
        super.defects.setSummary(new DefectsList(FAILED_SUMMARY_HEADER, EU_NUMBER_SUMMARY_HEADER));
    }

    @Override
    public DefectsListsGrouped getDefects() {
        return super.getDefects();
    }

    public MotFailCertificateData setFailureInformation(String failureInformation) {
        this.failureInformation = failureInformation;
        return this;
    }

    @JsonProperty("EuDangerousDefects")
    public MotFailCertificateData setEuDangerousDefects(List<String> euDangerousDefects) {
        DefectsList dangerousDefects = new DefectsList(DANGEROUS_DEFECTS_HEADER, euDangerousDefects, EU_NUMBER_FOR_DEFECTS);
        dangerousDefects.setIconSrc("assets/images/exclamation-mark.png");
        super.defects.setDangerous(dangerousDefects);
        return this;
    }

    @JsonProperty("EuMajorDefects")
    public MotFailCertificateData setEuMajorDefects(List<String> euMajorDefects) {
        super.defects.setMajor(new DefectsList(MAJOR_DEFECTS_HEADER, euMajorDefects, EU_NUMBER_FOR_DEFECTS));
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
}
