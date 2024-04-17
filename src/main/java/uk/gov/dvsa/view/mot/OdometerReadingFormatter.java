package uk.gov.dvsa.view.mot;

import org.apache.commons.lang3.StringUtils;
import uk.gov.dvsa.model.mot.certificateData.OdometerReading;

import java.util.Optional;

public class OdometerReadingFormatter {

    public static final String MILES_ENGLISH = "miles";
    public static final String MILES_WELSH = "milltiroedd";

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
            .map(unit -> " " + formatUnit(unit, false))
            .orElse("");
    }

    public String formatWelshValue(OdometerReading odometer) {
        if (odometer == null) {
            return "";
        }
        if (isRemark(odometer)) {
            return odometer.getValueCy();
        }

        return formatNumberValue(odometer.getValueCy()) +
                Optional.ofNullable(odometer.getUnit())
                        .map(unit -> " " + formatUnit(unit, true))
                        .orElse("");
    }

    private String formatUnit(String unit, Boolean unitWelsh) {
        switch (unit) {
            case MILES_UNIT:
                return unitWelsh ? MILES_WELSH : MILES_ENGLISH;
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
