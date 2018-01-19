package htmlverification.framework.page_object;

import htmlverification.framework.exception.HtmlElementNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

public abstract class BasePageObject {
    protected Document document;

    public BasePageObject(String htmlContent) {
        document = Jsoup.parse(htmlContent);
    }

    public Element getElement(String selector) {
        Element element = document.selectFirst(selector);

        return handleElementNotFound(element, String.format("selector: '%s'", selector));
    }

    public Element getElementById(String id) {
        Element elementById = document.getElementById(id);

        return handleElementNotFound(elementById, String.format("id : '%s'", id));
    }

    public String getTextOf(String id) {
        String textElement = getElementById(id).text();

        return handleElementNotFound(textElement, String.format("id containing text: '%s'", id));
    }

    protected <T> T handleElementNotFound(T element, String message) {
        return Optional.ofNullable(element).orElseThrow(() -> new HtmlElementNotFoundException(message));
    }
}
