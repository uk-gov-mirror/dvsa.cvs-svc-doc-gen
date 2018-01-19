package uk.gov.dvsa.model.mot.reasonforrejection;

import java.util.List;

public class Advisories extends ReasonsForRejectionGroup {
    private final String title = "Monitor and repair if necessary (advisories)";

    public Advisories(List<String> reasonsForRejection) {
        super(reasonsForRejection);
    }

    public String getTitle() {
        return title;
    }
}
