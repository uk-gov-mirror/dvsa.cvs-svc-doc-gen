package uk.gov.dvsa.model.mot.results;

import java.util.Collections;
import java.util.List;

public class ReasonForCancel extends ResultsItem {

    private final String reasonForCancelComment;


    public ReasonForCancel(String reasonForCancel, String reasonForCancelComment) {
        super(reasonForCancel, "");

        this.reasonForCancelComment = reasonForCancelComment;
    }

    public String getFirstItem() {
        return reasonForCancelComment;
    }

    public List<String> getOtherItems() {
        return Collections.emptyList();
    }

    public boolean isPresent() {
        return getTitle() != null && !getTitle().isEmpty();
    }
}
