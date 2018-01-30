package uk.gov.dvsa.model.mot.reasonforrejection;

import java.util.List;

public class DangerousDefects extends ReasonsForRejectionGroup {
    private final String title = "Do not drive until repaired (dangerous defects)";

    public DangerousDefects(List<String> reasonsForRejection) {
        super(reasonsForRejection);
    }

    public String getTitle() {
        return title;
    }
}
