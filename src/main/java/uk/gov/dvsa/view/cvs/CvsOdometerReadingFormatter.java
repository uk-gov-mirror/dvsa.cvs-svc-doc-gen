package uk.gov.dvsa.view.cvs;

import org.apache.commons.lang3.StringUtils;
import uk.gov.dvsa.model.cvs.certificateData.CvsOdometerReading;
import uk.gov.dvsa.model.mot.certificateData.OdometerReading;

import java.util.Optional;

public class CvsOdometerReadingFormatter {

    public static final String MILES = "miles";

    private static final String MILES_UNIT = "mi";
    private static final String KILOMETERS_UNIT = "km";
    private static final String THOUSANDS_PATTERN = "\\B(?=(?:.{3})+$)";
    private static final String THOUSANDS_SEPARATOR = ",";

    public String formatValue(CvsOdometerReading odometer) {
        if (odometer == null) {
            return "";
        }

        if (isRemark(odometer)) {
            return odometer.getValue();
        }

        return formatNumberValue(odometer.getValue()) +
            Optional.ofNullable(odometer.getUnit())
            .map(unit -> " " + formatUnit(unit, false))
            .orElse("");
    }

    private String formatUnit(String unit, Boolean unitWelsh) {
        switch (unit) {
            case MILES_UNIT:
                return MILES;
            case KILOMETERS_UNIT:
                return "km";
            default:
                return unit;
        }
    }

    private String formatNumberValue(String value) {
        return value.replaceAll(THOUSANDS_PATTERN, THOUSANDS_SEPARATOR);
    }

    private boolean isRemark(CvsOdometerReading odometer) {
        return !StringUtils.isNumeric(odometer.getValue());
    }
}
