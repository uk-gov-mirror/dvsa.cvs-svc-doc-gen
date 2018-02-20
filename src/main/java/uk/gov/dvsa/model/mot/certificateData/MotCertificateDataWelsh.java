package uk.gov.dvsa.model.mot.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.results.DefectsList;
import uk.gov.dvsa.model.mot.results.Summary;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MotCertificateDataWelsh extends MotCertificateData {

    public static final String PASS_SUMMARY_HEADER_WELSH = "Pasio";
    public static final String PASS_WITH_DEFECTS_HEADER_WELSH = "Pasio gyda diffygion";
    private static final String ADVISORIES_HEADER_WELSH = "Monitro a thrwsio os oes angen (cynghorol)";
    private static final String MINOR_DEFECTS_HEADER_WELSH = "Rhaid trwsio cyn gynted â phosibl (mân ddiffygion)";

    @JsonProperty("EuAdvisoryDefectsCy")
    private List<String> euAdvisoryDefectsCy;

    @JsonProperty("EuMinorDefectsCy")
    private List<String> euMinorDefectsCy;

    private String buildSummaryTitle() {
        if (!hasMinorDefects(euMinorDefectsCy)) {
            return PASS_SUMMARY_HEADER_WELSH;
        } else {
            return PASS_WITH_DEFECTS_HEADER_WELSH;
        }
    }

    public MotCertificateDataWelsh setEuAdvisoryDefectsCy(List<String> euAdvisoryDefectsCy) {
        this.euAdvisoryDefectsCy = euAdvisoryDefectsCy;
        return this;
    }

    public List<String> getEuAdvisoryDefectsCy() {
        return euAdvisoryDefectsCy;
    }

    public MotCertificateDataWelsh setEuMinorDefectsCy(List<String> euMinorDefectsCy) {
        this.euMinorDefectsCy = euMinorDefectsCy;
        return this;
    }

    public List<String> getEuMinorDefectsCy() {
        return euMinorDefectsCy;
    }

    public DefectsList getMinorCy() {
        return new DefectsList(MINOR_DEFECTS_HEADER_WELSH, this.euMinorDefectsCy, EU_NUMBER_FOR_DEFECTS);
    }

    public DefectsList getAdvisoryCy() {
        return new DefectsList(ADVISORIES_HEADER_WELSH, this.euAdvisoryDefectsCy);
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
        return new Summary(buildSummaryTitle());
    }
}
