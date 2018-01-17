package uk.gov.dvsa.model.reason_for_rejection;

import uk.gov.dvsa.service.ReasonForRejectionParser;

import java.util.List;

public abstract class ReasonsForRejectionGroup {
    private List<ReasonForRejection> reasonsForRejection;

    public List<ReasonForRejection> getReasonsForRejection() {
        return reasonsForRejection;
    }

    public void setReasonsForRejection(List<String> reasonsForRejection) {
        this.reasonsForRejection = ReasonForRejectionParser.parseAll(reasonsForRejection);
    }
}
