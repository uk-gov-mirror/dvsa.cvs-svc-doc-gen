package uk.gov.dvsa.model.mot.results;

public class DefectsListsGrouped {
    private DefectsList summary;
    private DefectsList dangerous;
    private DefectsList major;
    private DefectsList minor;
    private DefectsList advisory;

    public DefectsList getSummary() {
        return summary;
    }

    public void setSummary(DefectsList summary) {
        this.summary = summary;
    }

    public DefectsList getDangerous() {
        return dangerous;
    }

    public void setDangerous(DefectsList dangerous) {
        this.dangerous = dangerous;
    }

    public DefectsList getMajor() {
        return major;
    }

    public void setMajor(DefectsList major) {
        this.major = major;
    }

    public DefectsList getMinor() {
        return minor;
    }

    public void setMinor(DefectsList minor) {
        this.minor = minor;
    }

    public DefectsList getAdvisory() {
        return advisory;
    }

    public void setAdvisory(DefectsList advisory) {
        this.advisory = advisory;
    }

    public boolean isEmpty() {
        return (dangerous == null || dangerous.isEmpty())
                && (major == null || major.isEmpty())
                && (minor == null || minor.isEmpty())
                && (advisory == null || advisory.isEmpty());

    }

    public boolean hasMinor() {
        return minor != null && !minor.isEmpty();
    }
}
