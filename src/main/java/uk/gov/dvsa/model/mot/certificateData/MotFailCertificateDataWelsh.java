package uk.gov.dvsa.model.mot.certificateData;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import uk.gov.dvsa.model.mot.results.DefectsList;
import uk.gov.dvsa.model.mot.results.Summary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotFailCertificateDataWelsh extends MotFailCertificateData {

    public static final String FAIL_SUMMARY_HEADER_WELSH = "Methu";
    private static final String ADVISORIES_HEADER_WELSH = "Monitro a thrwsio os oes angen (cynghorol)";
    private static final String MINOR_DEFECTS_HEADER_WELSH = "Rhaid trwsio cyn gynted â phosibl (mân ddiffygion)";
    private static final String MAJOR_HEADER_WELSH = "Rhaid trwsio ar unwaith (diffygion pennaf)";
    private static final String DANGEROUS_HEADER_WELSH = "Peidiwch â gyrru nes iddo gael ei drwsio (diffygion peryglus)";

    @JsonProperty("EuAdvisoryDefectsCy")
    private List<String> euAdvisoryDefectsCy;

    @JsonProperty("EuMinorDefectsCy")
    private List<String> euMinorDefectsCy;

    @JsonProperty("EuDangerousDefectsCy")
    private List<String> euDangerousDefectsCy;

    @JsonProperty("EuMajorDefectsCy")
    private List<String> euMajorDefectsCy;

    public MotFailCertificateDataWelsh setEuAdvisoryDefectsCy(List<String> euAdvisoryDefectsCy) {
        this.euAdvisoryDefectsCy = euAdvisoryDefectsCy;
        return this;
    }

    public MotFailCertificateDataWelsh setEuMinorDefectsCy(List<String> euMinorDefectsCy) {
        this.euMinorDefectsCy = euMinorDefectsCy;
        return this;
    }

    public MotFailCertificateDataWelsh setEuDangerousDefectsCy(List<String> euDangerousDefectsCy) {
        this.euDangerousDefectsCy = euDangerousDefectsCy;
        return this;
    }

    public MotFailCertificateDataWelsh setEuMajorDefectsCy(List<String> euMajorDefectsCy) {
        this.euMajorDefectsCy = euMajorDefectsCy;
        return this;
    }

    public DefectsList getMinorCy() {
        return new DefectsList(MINOR_DEFECTS_HEADER_WELSH, this.euMinorDefectsCy, EU_NUMBER_FOR_DEFECTS);
    }

    public DefectsList getAdvisoryCy() {
        return new DefectsList(ADVISORIES_HEADER_WELSH, this.euAdvisoryDefectsCy);
    }

    public DefectsList getMajorCy() {
        return new DefectsList(MAJOR_HEADER_WELSH, this.euMajorDefectsCy, EU_NUMBER_FOR_DEFECTS);
    }

    public DefectsList getDangerousCy() {
        DefectsList dangerousDefects =  new DefectsList(DANGEROUS_HEADER_WELSH, this.euDangerousDefectsCy, EU_NUMBER_FOR_DEFECTS);
        return dangerousDefects.setIsDangerous(true);
    }

    public List<FormattedOdometerReading> getMileageHistoryCy() {
        if (null != getOdometerHistoryList()) {
            return getOdometerHistoryList().stream()
                .map(
                    entry -> new FormattedOdometerReading(
                        ODOMETER_FORMATTER.formatWelshValue(entry),
                        DATE_FORMATTER.format(entry.getDate())
                    )
                )
                .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public String getFormattedCurrentOdometerCy() {
        return ODOMETER_FORMATTER.formatWelshValue(getCurrentOdometer());
    }

    public Summary getSummaryCy() {
        return new Summary(FAIL_SUMMARY_HEADER_WELSH);
    }

}
