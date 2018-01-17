package html_verification.service;


import html_verification.model.CertificateInputData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CertificateTestDataProvider {
    private static Collection<Object[]> certificateTestData;

    public static CertificateInputData VT20;
    public static CertificateInputData VT30;
    public static CertificateInputData VT30WithOverflownRFRs;

    static {
        // TODO: Initialize the below objects with real data

        VT20 = new CertificateInputData("VT20");
        VT20.setCountry("GB")
                .setVIN("QQIDAAAAAAA058568")
                .setDateOfTheTest("12.10.2017")
                .setExpiryDate("12.10.2018")
                .setLocationOfTheTest("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
                .setMakeAndModel("Aston Martin DB11")
                .setVehicleCategory("M1")
                .setRegistrationNumber("KA1SAPH")
                .setMileage("22,341 miles")
                .setDateOfTheTest("12.10.2017")
                .setTestingOrgAndInspName("MILKE GROUP LIMITED R.DREWNO")
                .setMotTestNumber("1806 8140 0628");

        VT30 = new CertificateInputData("VT30");
        VT30.setCountry("GB")
                .setVIN("QQIDAAAAAAA058568")
                .setDateOfTheTest("12.10.2017")
                .setExpiryDate("12.10.2018")
                .setLocationOfTheTest("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
                .setMakeAndModel("Aston Martin DB11")
                .setVehicleCategory("M1")
                .setRegistrationNumber("KA1SAPH")
                .setMileage("22,341 miles")
                .setDateOfTheTest("12.10.2017")
                .setTestingOrgAndInspName("MILKE GROUP LIMITED R.DREWNO")
                .setMotTestNumber("1806 8140 0628");

        VT30WithOverflownRFRs = new CertificateInputData("VT30 with overflown rfrs");
        VT30WithOverflownRFRs.setCountry("GB")
                .setVIN("QQIDAAAAAAA058568")
                .setDateOfTheTest("12.10.2017")
                .setExpiryDate("12.10.2018")
                .setLocationOfTheTest("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
                .setMakeAndModel("Aston Martin DB11")
                .setVehicleCategory("M1")
                .setRegistrationNumber("KA1SAPH")
                .setMileage("22,341 miles")
                .setDateOfTheTest("12.10.2017")
                .setTestingOrgAndInspName("MILKE GROUP LIMITED R.DREWNO")
                .setMotTestNumber("1806 8140 0628");

        certificateTestData = Arrays.asList(new Object[][] {
                { VT20 },
                { VT30 },
                { VT30WithOverflownRFRs }
        });
    }

    public static Collection<Object[]> getCertificatesTestData() {
        return certificateTestData;
    }

    public static List<CertificateInputData> getCertificatesData() {
        List<CertificateInputData> certificatesData = new ArrayList<>();

        certificateTestData.forEach(testDataEntry -> certificatesData.add((CertificateInputData)testDataEntry[0]));

        return certificatesData;
    }
}
