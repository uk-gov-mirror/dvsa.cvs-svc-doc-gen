package uk.gov.dvsa.model.mot;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateData;

public class VT20 extends MotCertificate {

    public Document setData(MotCertificateData data) {
        this.data = data;
        return this;
    }
}
