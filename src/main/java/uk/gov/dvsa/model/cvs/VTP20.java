package uk.gov.dvsa.model.cvs;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.CvsMotCertificateData;
import uk.gov.dvsa.model.mot.MotCertificate;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateData;

public class VTP20 extends CvsMotCertificate {

    public Document setData(CvsMotCertificateData data) {
        this.data = data;
        return this;
    }

    public String getTestType() {
        return "PSV";
    }

    public String getPresentedDocumentNamePass() {
        return "VTP20";
    }

    public String getVersionNumberPass() {
        return "1.0";
    }
}
