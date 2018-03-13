package uk.gov.dvsa.model.mot;

import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;

public class PRSW extends MotFailCertificate {
    public Document setData(MotCertificateDataWelsh data) {
        this.data = data;
        return this;
    }

    public Document setFailData(MotFailCertificateDataWelsh failData) {
        this.failData = failData;
        return this;
    }
}
