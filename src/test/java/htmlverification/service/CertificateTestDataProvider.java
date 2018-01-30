package htmlverification.service;


import uk.gov.dvsa.model.mot.MotFailCertificateData;
import uk.gov.dvsa.model.mot.VT30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CertificateTestDataProvider {
    public static final String VIN = "QQIDAAAAAAA058568";

    public static VT30 getVt30() {
        VT30 vt30 = new VT30();
        vt30.setDocumentName("MOT/VT30");
        MotFailCertificateData vt30Data = new MotFailCertificateData();
        vt30Data
            .setEuDangerousDefects(generateRFRs("Reason for rejection", 2))
            .setEuAdvisoryDefects(generateRFRs("Advisory", 3))
            .setCountryOfRegistration("GB")
            .setVin(VIN)
            .setIssuedDate("12.10.2017")
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("12.10.2010")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("M1")
            .setVrm("KA1SAPH")
            .setOdometer("22,341 miles")
            .setOdometerHistory(Arrays.asList("200 miles", "300 miles"))
            .setIssuersName("")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setTestNumber("1806 8140 0628");
        vt30.setData(vt30Data);

        return vt30;
    }

    public static VT30 getVt30WithOverflownRFRs() {
        VT30 vt30WithOverflownRFRs = new VT30();
        vt30WithOverflownRFRs.setDocumentName("MOT/VT30");
        MotFailCertificateData vt30WithOverflownRFRsData = new MotFailCertificateData();
        vt30WithOverflownRFRsData
            .setEuDangerousDefects(generateRFRs("Reason for rejection", 60))
            .setEuAdvisoryDefects(generateRFRs("Advisory", 3))
            .setCountryOfRegistration("GB")
            .setVin(VIN)
            .setIssuedDate("12.10.2017")
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("12.10.2010")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("M1")
            .setVrm("KA1SAPH")
            .setOdometer("22,341 miles")
            .setOdometerHistory(Arrays.asList("200 miles", "300 miles"))
            .setIssuersName("")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setTestNumber("1806 8140 0628");

        vt30WithOverflownRFRs.setData(vt30WithOverflownRFRsData);
        return vt30WithOverflownRFRs;
    }

    public static Collection<Object[]> getCertificatesTestData() {
        return Arrays.asList(new Object[][] {
                { getVt30() },
                { getVt30WithOverflownRFRs() }
        });
    }

    private static List<String> generateRFRs(String rfrName, int numberOfRfrs) {
        List<String> reasonsForRejection = new ArrayList<>();

        for (int i = 0; i < numberOfRfrs; i++) {
            reasonsForRejection.add(rfrName + " #" + i); }
        return reasonsForRejection;
    }
}
