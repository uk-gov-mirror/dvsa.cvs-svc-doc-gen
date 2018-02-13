package htmlverification.service;


import htmlverification.framework.component.DefectSummaryComponent;
import uk.gov.dvsa.model.mot.MotCertificateData;
import uk.gov.dvsa.model.mot.MotFailCertificateData;
import uk.gov.dvsa.model.mot.OdometerReading;
import uk.gov.dvsa.model.mot.VT20;
import uk.gov.dvsa.model.mot.VT30;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CertificateTestDataProvider {
    public static final String VIN = "QQIDAAAAAAA058568";
    public static final String ADVISORY_RFR_TEXT = "Advisory RFR";
    public static final String DANGEROUS_RFR_TEXT = "Dangerous RFR";
    public static final String MAJOR_RFR_TEXT = "Major RFR";
    public static final String MINOR_RFR_TEXT = "Minor RFR";

    public static VT20 getVt20() {
        VT20 vt20 = new VT20();
        vt20.setDocumentName("MOT/VT20");
        MotCertificateData vt20Data = new MotCertificateData();
        vt20Data
            .setMinorDefectsHeader(DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT)
            .setEuMinorDefects(generateRFRs(MINOR_RFR_TEXT, 5))

            .setAdvisoryDefectsHeader(DefectSummaryComponent.ADVISORIES_HEADER_TEXT)
            .setEuAdvisoryDefects(generateRFRs(ADVISORY_RFR_TEXT, 3))

            .setCountryOfRegistrationCode("GB")
            .setRawVin(VIN)
            .setIssuedDate("12.10.2017")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setDateOfTheExpiryTest("12.10.2018")
            .setFirstUseDate("12.10.2010")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer("22,341 miles")
            .setCurrentOdometer(
                new OdometerReading("22341", "mi", LocalDate.now())
            )
            .setOdometerHistory("1 2 2016 200 miles\n 30 1 2017 300 miles")
            .setOdometerHistoryList(Arrays.asList(
                new OdometerReading("120", "km", LocalDate.of(2016, 2, 1)),
                new OdometerReading("330", "km", LocalDate.of(2017, 1, 30))
            ))
            .setIssuersName("R.DREWNO")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setAuthorisedExaminer("MILKE GROUP LIMITED")
            .setTestNumber("1806 8140 0628");
        vt20.setData(vt20Data);

        return vt20;
    }

    public static VT30 getVt30() {
        VT30 vt30 = new VT30();
        vt30.setDocumentName("MOT/VT30");
        MotFailCertificateData vt30Data = new MotFailCertificateData();
        vt30Data
            .setDangerousDefectsHeader(DefectSummaryComponent.DANGEROUS_DEFECTS_HEADER_TEXT)
            .setEuDangerousDefects(generateRFRs(DANGEROUS_RFR_TEXT, 2))

            .setMajorDefectsHeader(DefectSummaryComponent.MAJOR_DEFECTS_HEADER_TEXT)
            .setEuMajorDefects(generateRFRs(MAJOR_RFR_TEXT, 4))

            .setMinorDefectsHeader(DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT)
            .setEuMinorDefects(generateRFRs(MINOR_RFR_TEXT, 5))

            .setAdvisoryDefectsHeader(DefectSummaryComponent.ADVISORIES_HEADER_TEXT)
            .setEuAdvisoryDefects(generateRFRs(ADVISORY_RFR_TEXT, 3))

            .setCountryOfRegistrationCode("GB")
            .setRawVin(VIN)
            .setIssuedDate("12.10.2017")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("12.10.2010")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer("22,341 miles")
            .setOdometerHistory("1 2 2016 200 miles\n 30 1 2017 300 miles")
            .setCurrentOdometer(
                new OdometerReading("22341", "mi", LocalDate.now())
            )
            .setOdometerHistoryList(Arrays.asList(
                new OdometerReading("200", "mi", LocalDate.of(2016, 02, 01)),
                new OdometerReading("300", "mi", LocalDate.of(2017, 01, 30))
            ))
            .setIssuersName("R.DREWNO")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setAuthorisedExaminer("MILKE GROUP LIMITED")
            .setTestNumber("1806 8140 0628");
        vt30.setData(vt30Data);

        return vt30;
    }

    public static VT30 getVt30WithOverflownRFRs() {
        VT30 vt30WithOverflownRFRs = new VT30();
        vt30WithOverflownRFRs.setDocumentName("MOT/VT30");
        MotFailCertificateData vt30WithOverflownRFRsData = new MotFailCertificateData();
        vt30WithOverflownRFRsData
            .setDangerousDefectsHeader(DefectSummaryComponent.DANGEROUS_DEFECTS_HEADER_TEXT)
            .setEuDangerousDefects(generateRFRs(DANGEROUS_RFR_TEXT, 60))

            .setAdvisoryDefectsHeader(DefectSummaryComponent.ADVISORIES_HEADER_TEXT)
            .setEuAdvisoryDefects(generateRFRs(ADVISORY_RFR_TEXT, 3))

            .setCountryOfRegistrationCode("GB")
            .setRawVin(VIN)
            .setIssuedDate("12.10.2017")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("12.10.2010")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer("22,341 miles")
            .setOdometerHistory("1 2 2016 200 miles\n 30 1 2017 300 miles")
            .setCurrentOdometer(
                new OdometerReading("22341", "mi", LocalDate.now())
            )
            .setOdometerHistoryList(Arrays.asList(
                new OdometerReading("200", "mi", LocalDate.of(2016, 02, 01)),
                new OdometerReading("300", "mi", LocalDate.of(2017, 01, 30))
            ))

            .setIssuersName("R.DREWNO")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setAuthorisedExaminer("MILKE GROUP LIMITED")
            .setTestNumber("180681400628");

        vt30WithOverflownRFRs.setData(vt30WithOverflownRFRsData);
        return vt30WithOverflownRFRs;
    }

    public static Collection<Object[]> getCertificatesTestData() {
        return Arrays.asList(new Object[][] {
                { getVt20() },
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
