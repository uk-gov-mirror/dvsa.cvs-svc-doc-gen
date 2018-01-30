package htmlverification.framework.component;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DefectSummaryComponent {
    public static final String RESULT_ITEM_CLASS = "results__item";

    public static final Integer RESULT_NAME_INDEX = 0;
    public static final String  MAJOR_DEFECTS_HEADER_TEXT = "Repair immediately (major defects)";
    public static final String  MINOR_DEFECTS_HEADER_TEXT = "Repair as soon as possible (minor defects)";
    public static final String  ADVISORIES_HEADER_TEXT = "Monitor and repair if necessary (advisories)";
    public static final String  DANGEROUS_DEFECTS_HEADER_TEXT = "Do not drive until repaired (dangerous defects)";

    protected Element resultSummaryElement;

    public DefectSummaryComponent(Element resultSummaryElement) {
        this.resultSummaryElement = resultSummaryElement;
    }

    public Elements getResultItems() {
        return resultSummaryElement.getElementsByClass(RESULT_ITEM_CLASS);
    }

    public Element getResultNameItem() {
        return getResultItems().get(RESULT_NAME_INDEX);
    }

    public Elements getMajorDefects() {
        return getResultItemEntries(MAJOR_DEFECTS_HEADER_TEXT);
    }

    public Elements getMinorDefects() {
        return getResultItemEntries(MINOR_DEFECTS_HEADER_TEXT);
    }

    public Elements getAdvisories() {
        return getResultItemEntries(ADVISORIES_HEADER_TEXT);
    }

    public Elements getDangerousDefects() {
        return getResultItemEntries(DANGEROUS_DEFECTS_HEADER_TEXT);
    }

    protected Elements getResultItemEntries(String resultItemHeader) {
        return getResultItems().stream()
                .filter(i -> i.getElementsContainingOwnText(resultItemHeader).size() > 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("The result summary does not contain element with text: '%s'", resultItemHeader)))
                .getElementsByTag("li");
    }

}
