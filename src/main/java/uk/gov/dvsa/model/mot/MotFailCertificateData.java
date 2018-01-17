package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.defect.DefectsList;
import uk.gov.dvsa.model.mot.defect.DefectsListsGrouped;

import java.util.List;

public class MotFailCertificateData extends MotCertificateData {

    public static final String FAILED_SUMMARY_HEADER = "Fail"; // header displayed above other lists of RFRs
    public static final String EU_NUMBER_FOR_DEFECTS = "6";

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

    @JsonProperty("MinorDefectsHeader")
    private String minorDefectsHeader;

    @JsonProperty("EuDangerousDefects")
    private List<String> euDangerousDefects;

    @JsonProperty("EuMajorDefects")
    private List<String> euMajorDefects;

    @JsonProperty("EuMinorDefects")
    private List<String> euMinorDefects;


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

    public MotFailCertificateData setEuDangerousDefects(List<String> euDangerousDefects) {
        super.defects.setDangerous(new DefectsList(getDangerousDefectsHeader(), euDangerousDefects, EU_NUMBER_FOR_DEFECTS));
        this.euDangerousDefects = euDangerousDefects;
        return this;
    }

    public MotFailCertificateData setEuMajorDefects(List<String> euMajorDefects) {
        super.defects.setMajor(new DefectsList(getMajorDefectsHeader(), euMajorDefects, EU_NUMBER_FOR_DEFECTS));
        this.euMajorDefects = euMajorDefects;
        return this;
    }

    public MotFailCertificateData setEuMinorDefects(List<String> euMinorDefects) {
        super.defects.setMinor(new DefectsList(getMinorDefectsHeader(), euMinorDefects, EU_NUMBER_FOR_DEFECTS));
        this.euMajorDefects = euMinorDefects;
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

    public String getMinorDefectsHeader() {
        return minorDefectsHeader;
    }

    public MotFailCertificateData setMinorDefectsHeader(String minorDefectsHeader) {
        this.minorDefectsHeader = minorDefectsHeader;
        return this;
    }
}
