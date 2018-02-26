package uk.gov.dvsa.model.mot;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;

public class VT30W extends MotFailCertificate {

    public Document setData(MotFailCertificateDataWelsh data) {
        this.data = data;
        return this;
    }
}
