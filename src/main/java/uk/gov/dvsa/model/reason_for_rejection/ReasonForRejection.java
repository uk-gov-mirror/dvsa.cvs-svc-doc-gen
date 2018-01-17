package uk.gov.dvsa.model.reason_for_rejection;

public class ReasonForRejection {
    private String testItemSelectorDescription;
    private String failureText;
    private String locationLateral;
    private String locationLongitudinal;
    private String locationVertical;
    private String comment;

    public String getTestItemSelectorDescription() {
        return testItemSelectorDescription;
    }

    public void setTestItemSelectorDescription(String testItemSelectorDescription) {
        this.testItemSelectorDescription = testItemSelectorDescription;
    }

    public String getFailureText() {
        return "[TODO] " + failureText;
    }

    public void setFailureText(String failureText) {
        this.failureText = failureText;
    }

    public String getLocationLateral() {
        return locationLateral;
    }

    public void setLocationLateral(String locationLateral) {
        this.locationLateral = locationLateral;
    }

    public String getLocationLongitudinal() {
        return locationLongitudinal;
    }

    public void setLocationLongitudinal(String locationLongitudinal) {
        this.locationLongitudinal = locationLongitudinal;
    }

    public String getLocationVertical() {
        return locationVertical;
    }

    public void setLocationVertical(String locationVertical) {
        this.locationVertical = locationVertical;
    }

    public String getComment() {
        if (comment != null) {
            return String.format("(%s)", comment);
        }
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("%s %s", failureText, comment);
    }
}
