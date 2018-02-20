package uk.gov.dvsa.model.mot;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh;

public class VT20W extends MotCertificate {

    public Document setData(MotCertificateDataWelsh data) {
        this.data = data;
        return this;
    }
}
