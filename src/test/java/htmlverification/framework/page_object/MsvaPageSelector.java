package htmlverification.framework.page_object;

public enum MsvaPageSelector {
    SERIAL_NO("serial-no"),
    VEH_Z_NO("veh-z-no"),
    TYPE("type"),
    MAKE_MODEL("make-model"),
    VIN("vin-chassis-no"),
    DATE("date"),
    RE_APP_DATE("re-app-date"),
    TESTER_NAME("tester-name"),
    STATION("station"),
    REQUIRED_STANDARDS("required-standards"),
    ADDITIONAL_DEFECTS("additional-defects");

    private final String selector;

    MsvaPageSelector(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
