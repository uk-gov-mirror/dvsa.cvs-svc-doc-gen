package uk.gov.dvsa.model.mot.results;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefectsList extends ResultsItem {

    /**
     * Path to an iconSrc displayed along with the title
     */
    private String iconSrc;

    private List<String> reasonsForRejection = new ArrayList<>();

    public DefectsList(String title, String euCompliantNumber) {
        super(title, euCompliantNumber);
    }

    public DefectsList(String title, List<String> reasonsForRejection) {
        super(title, "");
        this.reasonsForRejection = reasonsForRejection;
    }

    public DefectsList(String title, List<String> reasonsForRejection, String euCompliantNumber) {
        this(title, euCompliantNumber);
        this.reasonsForRejection = reasonsForRejection;
    }

    /**
     * The first RFR has to be returned separately from the rest of the group
     * due to special HTML/Handlebars formatting that puts it in an unbreakable section with the header above it
     */
    public String getFirstItem() {
        if (reasonsForRejection.isEmpty()) {
            return null;
        }
        return reasonsForRejection.get(0);
    }

    /**
     * All RFRs except for the first one are returned as a List
     */
    public List<String> getOtherItems() {
        if (reasonsForRejection.isEmpty()) {
            return null;
        }
        return this.reasonsForRejection.subList(1, reasonsForRejection.size());
    }

    public String getIconSrc() {
        return iconSrc;
    }

    public void setIconSrc(String iconSrc) {
        this.iconSrc = iconSrc;
    }

    public boolean isEmpty() {
        return Optional.ofNullable(this.reasonsForRejection)
                .map(List::isEmpty)
                .orElse(true);
    }

    public boolean isPresent() {
        return !isEmpty();
    }
}
