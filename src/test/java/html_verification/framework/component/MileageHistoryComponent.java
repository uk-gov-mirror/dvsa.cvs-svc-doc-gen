package html_verification.framework.component;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MileageHistoryComponent {
    protected Element mileageHistoryElement;

    public MileageHistoryComponent(Element mileageHistoryElement) {
        this.mileageHistoryElement = mileageHistoryElement;
    }

    public Elements getEntries() {
        Elements entriesLists = mileageHistoryElement.select("ul");
        if(entriesLists.size() > 1) {
            throw new RuntimeException("More than one entries list found!");
        }

        return entriesLists.first().select("li");
    }

}
