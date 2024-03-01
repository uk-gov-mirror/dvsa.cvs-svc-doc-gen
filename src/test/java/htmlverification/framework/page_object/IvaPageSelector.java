package htmlverification.framework.page_object;

public enum IvaPageSelector {
    SERIAL_NO("serial-no"),
    VEH_TRL_NO("veh-trl-no"),
    TEST_CATEGORY("test-category"),
    MAKE_MODEL("make-model"),
    VIN("vin-chassis-no"),
    BODY_TYPE("body-type"),
    DATE("date"),
    RE_APP_DATE("re-app-date"),
    TESTER_NAME("tester-name"),
    STATION("station"),
    REQUIRED_STANDARDS("required-standards"),
    ADDITIONAL_DEFECTS("additional-defects");

    private final String selector;

    IvaPageSelector(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
