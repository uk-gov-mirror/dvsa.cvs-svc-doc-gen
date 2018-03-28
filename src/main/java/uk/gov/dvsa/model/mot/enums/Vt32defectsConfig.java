package uk.gov.dvsa.model.mot.enums;

public enum Vt32defectsConfig {
    ADVISORY_DEFECTS_WELSH("Monitor and repair if necessary (advisories) / Monitro a thrwsio os oes angen (cynghorol)", true, true),
    MINOR_DEFECTS_WELSH("Repair as soon as possible (minor defects) / Rhaid trwsio cyn gynted â phosibl (mân ddiffygion)", true, true),
    MAJOR_DEFECTS_WELSH("Repair immediately (major defects) / Rhaid trwsio ar unwaith (diffygion pennaf)", true, true),
    DANGEROUS_DEFECTS_WELSH("Peidiwch â gyrru nes iddo gael ei drwsio (diffygion peryglus)", true, true),
    PRE_EU_FAIL_DEFECTS_WELSH("Tested Items that failed / Eitemau profedig ffaeledig", true, false),
    PRE_EU_ADVISORIES_WELSH("Advisory items / Eitemau Ymgynghorol", true, false),
    ADVISORY_DEFECTS("Monitor and repair if necessary (advisories)", false, true),
    MINOR_DEFECTS("Repair as soon as possible (minor defects)", false, true),
    MAJOR_DEFECTS("Repair immediately (major defects)", false, true),
    DANGEROUS_DEFECTS("Do not drive until repaired (dangerous defects)", false, true),
    PRE_EU_FAIL_DEFECTS("Tested Items that failed", false, false),
    PRE_EU_ADVISORIES("Advisory items", false, false);

    private String headerText;
    private boolean isWelsh;
    private boolean isPostEu;

    Vt32defectsConfig(String headerText, boolean isWelsh, boolean isPostEu) {
        this.headerText = headerText;
        this.isWelsh = isWelsh;
        this.isPostEu = isPostEu;
    }

    public String getHeaderText() {
        return headerText;
    }

    public boolean isWelsh() {
        return isWelsh;
    }

    public boolean isPostEu() {
        return isPostEu;
    }
}
