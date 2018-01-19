package uk.gov.dvsa.model.mot.reasonforrejection;

import java.util.List;

/**
 * This is the header displayed just above dangerous defects, marked with number (7) according to EU roadworthiness labeling
 */
public class FailedSummaryHeader extends ReasonsForRejectionGroup {
    private final String title = "Fail";

    public FailedSummaryHeader() {}

    // it should not contain anything besides the title
    private FailedSummaryHeader(List<String> reasonsForRejection) {
        super(reasonsForRejection);
    }

    public String getTitle() {
        return title;
    }
}
