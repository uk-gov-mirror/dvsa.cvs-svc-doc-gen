package uk.gov.dvsa.model.mot.reasonforrejection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ReasonsForRejectionGroup {
    private List<String> reasonsForRejection = new ArrayList<>();

    ReasonsForRejectionGroup(List<String> reasonsForRejection) {
        this.reasonsForRejection = reasonsForRejection;
    }

    ReasonsForRejectionGroup() {}

    public ReasonsForRejectionGroup setReasonsForRejection(List<String> reasonsForRejection) {
        this.reasonsForRejection = reasonsForRejection;
        return this;
    }

    /**
     * The first RFR has to be returned separately from the rest of the group
     * due to special HTML/Handlebars formatting that puts it in an unbreakable section with the header above it
     */
    public ReasonForRejection getFirstItem() {
        if (reasonsForRejection == null || reasonsForRejection.isEmpty()) {
            return null;
        }
        return parseReasonForRejection(reasonsForRejection.get(0));
    }

    /**
     * All RFRs except for the first one are returned as a List
     */
    public List<ReasonForRejection> getOtherItems() {
        if (reasonsForRejection == null || reasonsForRejection.isEmpty()) {
            return null;
        }
        return parseAll(this.reasonsForRejection).subList(1, reasonsForRejection.size());
    }

    public List<ReasonForRejection> parseAll(List<String> rawReasonsForRejection) {
        return rawReasonsForRejection.stream().map(this::parseReasonForRejection).collect(Collectors.toList());
    }

    private ReasonForRejection parseReasonForRejection(String rfrText) {
        ReasonForRejection reasonForRejection = new ReasonForRejection();
        reasonForRejection.setFailureText(rfrText);
        return reasonForRejection;
    }

}
