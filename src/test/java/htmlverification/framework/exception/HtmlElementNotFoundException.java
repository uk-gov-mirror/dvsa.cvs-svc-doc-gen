package htmlverification.framework.exception;

public class HtmlElementNotFoundException extends RuntimeException {
    private String elementSelector;

    public HtmlElementNotFoundException(String elementSelector) {
        this.elementSelector = elementSelector;
    }

    @Override
    public String getMessage() {
        return String.format("Could not find HTML element using the following %s", elementSelector);
    }
}
