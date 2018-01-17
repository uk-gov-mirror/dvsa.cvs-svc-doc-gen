package html_verification.framework.page_object;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class BasePageObject {
    protected Document document;

    public BasePageObject(String htmlContent) {
        document = Jsoup.parse(htmlContent);
    }

    public Element getElement(String selector) {
        return document.selectFirst(selector);
    }

    public Element getElementById(String id) {
        return document.getElementById(id);
    }

    public String getTextOf(String id) {
        return getElementById(id).text();
    }

}
