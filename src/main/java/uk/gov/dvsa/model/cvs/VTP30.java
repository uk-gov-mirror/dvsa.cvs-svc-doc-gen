package uk.gov.dvsa.model.cvs;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.cvs.certificateData.CvsMotCertificateData;
import uk.gov.dvsa.model.cvs.certificateData.CvsMotFailCertificateData;

public class VTP30 extends CvsMotFailCertificate {

    public String getTestType() {
        return "PSV";
    }

    public String getPresentedDocumentNameFail() {
        return "VTP30";
    }

    public String getVersionNumberFail() {
        return "1.0";
    }
}
