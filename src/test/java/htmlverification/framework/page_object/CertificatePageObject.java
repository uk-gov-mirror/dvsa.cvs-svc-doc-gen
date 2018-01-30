package htmlverification.framework.page_object;

import htmlverification.framework.component.DefectSummaryComponent;
import htmlverification.framework.component.MileageHistoryComponent;
import org.jsoup.nodes.Element;

import static htmlverification.framework.page_object.CertificatePageSelector.*;

public class CertificatePageObject extends BasePageObject {

    public CertificatePageObject(String htmlContent) {
        super(htmlContent);
    }

    public MileageHistoryComponent getMileageHistoryComponent() {
        Element mileageHistoryElement = getElementById(CertificatePageSelector.MILEAGE_HISTORY_ID.getSelector());

        return new MileageHistoryComponent(mileageHistoryElement);
    }

    public DefectSummaryComponent getDefectSummaryComponent() {
        Element defectSummaryElement = getElement("." + RESULTS_SUMMARY_CLASS.getSelector());

        return new DefectSummaryComponent(defectSummaryElement);
    }

}
