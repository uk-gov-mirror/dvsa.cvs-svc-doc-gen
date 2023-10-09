package uk.gov.dvsa.model.cvs;

public class CvsPsvPassBilingual extends VTP20W {

    public String getTestType() {
        return "PSV";
    }

    public String getPresentedDocumentNamePass() {
        return "VTP20";
    }

    public String getPresentedDocumentNamePassWelsh() {
        return "VTP20W";
    }

    public String getVersionNumberPass() {
        return "1.0";
    }

    public String getVersionNumberPassWelsh() {
        return "1.0";
    }

    public String getRegOrIdHeading() {
        return "Registration number";
    }
}
