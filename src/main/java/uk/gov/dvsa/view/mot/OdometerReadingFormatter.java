package uk.gov.dvsa.view.mot;

import org.apache.commons.lang3.StringUtils;
import uk.gov.dvsa.model.mot.OdometerReading;

import java.util.Optional;

public class OdometerReadingFormatter {

    private static final String MILES_UNIT = "mi";
    private static final String KILOMETERS_UNIT = "km";
    private static final String THOUSANDS_PATTERN = "\\B(?=(?:.{3})+$)";
    private static final String THOUSANDS_SEPARATOR = ",";

    public String formatValue(OdometerReading odometer) {
        if (odometer == null) {
            return "";
        }

        if (isRemark(odometer)) {
            return odometer.getValue();
        }

        return formatNumberValue(odometer.getValue()) +
            Optional.ofNullable(odometer.getUnit())
            .map(unit -> " " + formatUnit(unit))
            .orElse("");
    }

    private String formatUnit(String unit) {
        switch (unit) {
            case MILES_UNIT:
                return "miles";
            case KILOMETERS_UNIT:
                return "km";
            default:
                return unit;
        }
    }

    private String formatNumberValue(String value) {
        return value.replaceAll(THOUSANDS_PATTERN, THOUSANDS_SEPARATOR);
    }

    private boolean isRemark(OdometerReading odometer) {
        return !StringUtils.isNumeric(odometer.getValue());
    }
}
