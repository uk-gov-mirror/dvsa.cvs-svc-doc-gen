package uk.gov.dvsa.model.mot;

import java.util.List;

public class VT32VE extends MotFailCertificate {

    private List<String> defectElements;

    private int currentPageNumber;

    private int maxPageNumber;

    private boolean isWelsh;

    private boolean isPostEu;

    public List<String> getDefectElements() {
        return defectElements;
    }

    public VT32VE setDefectElements(List<String> defectElements) {
        this.defectElements = defectElements;
        return this;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }

    public void setMaxPageNumber(int maxPageNumber) {
        this.maxPageNumber = maxPageNumber;
    }

    public boolean isWelsh() {
        return isWelsh;
    }

    public void setWelsh(boolean welsh) {
        isWelsh = welsh;
    }

    public boolean isPostEu() {
        return isPostEu;
    }

    public void setPostEu(boolean postEu) {
        isPostEu = postEu;
    }
}
