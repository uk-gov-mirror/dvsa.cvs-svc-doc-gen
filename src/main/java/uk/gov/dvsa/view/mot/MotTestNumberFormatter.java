package uk.gov.dvsa.view.mot;

import java.util.Optional;

public class MotTestNumberFormatter {
    private static final String TEST_NUMBER_PATTERN = "\\B(?=(?:.{4})+$)";
    private static final String TEST_NUMBER_SEPARATOR = " ";
    private static final String NOT_RECORDED_VALUE = "Not recorded";
    private static final String NOT_RECORDED_WELSH_VALUE = "Heb gofnodi";

    public String format(String testNumber) {
        return Optional.ofNullable(testNumber)
            .filter(MotTestNumberFormatter::isNotEmpty)
            .map(MotTestNumberFormatter::formatNumber)
            .orElse(NOT_RECORDED_VALUE);
    }

    public String formatWelsh(String testNumber) {
        return Optional.ofNullable(testNumber)
            .filter(MotTestNumberFormatter::isNotEmpty)
            .map(MotTestNumberFormatter::formatNumber)
            .orElse(NOT_RECORDED_WELSH_VALUE);
    }

    private static boolean isNotEmpty(String input) {
        return !input.isEmpty();
    }

    private static String formatNumber(String input) {
        return input.replace(TEST_NUMBER_SEPARATOR, "")
            .replaceAll(TEST_NUMBER_PATTERN, TEST_NUMBER_SEPARATOR);
    }
}
