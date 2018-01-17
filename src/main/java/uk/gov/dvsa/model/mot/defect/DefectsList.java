package uk.gov.dvsa.model.mot.defect;

import java.util.ArrayList;
import java.util.List;

public class DefectsList {

    /**
     *  Displayed together with the title, may contain letters, optional
     */
    private String euCompliantNumber;

    /**
     *  Header describing a list of reasons for rejection that are displayed below it
     */
    private String title;

    private List<String> reasonsForRejection = new ArrayList<>();

    public DefectsList(String title, String euCompliantNumber) {
        this.title = title;
        this.euCompliantNumber = euCompliantNumber;
    }

    public DefectsList(String title, List<String> reasonsForRejection) {
        this.title = title;
        this.reasonsForRejection = reasonsForRejection;
        this.euCompliantNumber = "";
    }

    public DefectsList(String title, List<String> reasonsForRejection, String euCompliantNumber) {
        this(title, euCompliantNumber);
        this.reasonsForRejection = reasonsForRejection;
    }

    public DefectsList setReasonsForRejection(String title, List<String> reasonsForRejection) {
        this.reasonsForRejection = reasonsForRejection;
        this.title = title;
        return this;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEuCompliantNumber() {
        return euCompliantNumber;
    }

    public void setEuCompliantNumber(String euCompliantNumber) {
        this.euCompliantNumber = euCompliantNumber;
    }
}
