package htmlverification.service;

import htmlverification.framework.component.DefectSummaryComponent;
import uk.gov.dvsa.model.mot.*;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateData;
import uk.gov.dvsa.model.mot.certificateData.MotCertificateDataWelsh;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateData;
import uk.gov.dvsa.model.mot.certificateData.MotFailCertificateDataWelsh;
import uk.gov.dvsa.model.mot.certificateData.OdometerReading;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static uk.gov.dvsa.view.mot.OdometerReadingFormatter.MILES_ENGLISH;

public class CertificateTestDataProvider {
    public static final String VIN = "QQIDAAAAAAA058568";
    public static final String ADVISORY_RFR_TEXT = "Advisory RFR";
    public static final String DANGEROUS_RFR_TEXT = "Dangerous RFR";
    public static final String MAJOR_RFR_TEXT = "Major RFR";
    public static final String MINOR_RFR_TEXT = "Minor RFR";
    public static final String ADVISORY_RFR_WELSH_TEXT = "Advisory Welsh RFR";
    public static final String MINOR_RFR_WELSH_TEXT = "Minor Welsh RFR";
    public static final String MAJOR_RFR_WELSH_TEXT = "Major Welsh RFR";
    public static final String DANGEROUS_RFR_WELSH_TEXT = "Dangerous Welsh RFR";

    public static final String ODOMETER_VALUE = "22,341";

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
            .setIssuedDate("2017-10-12")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setDateOfTheExpiryTest("12.10.2018")
            .setFirstUseDate("2010-10-12")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer(ODOMETER_VALUE + " " + MILES_ENGLISH)
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
            .setTestNumber("1806 8140 0628")
            .setEarliestDateOfTheNextTest(LocalDate.of(2018, 10, 13));
        vt20.setData(vt20Data);

        return vt20;
    }

    public static VT20 getVt20Duplicate() {
        VT20 vt20 = getVt20();
        vt20.setCertificateIssuerInfo("Duplicate certificate issued by B. T. Arctor Tester1 on 13 February 2018");
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
            .setIssuedDate("2017-10-12")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("2010-10-12")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer(ODOMETER_VALUE + " " + MILES_ENGLISH)
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
            .setTestNumber("1806 8140 0628")
            .setEarliestDateOfTheNextTest(LocalDate.of(2018, 10, 13));
        vt30.setData(vt30Data);

        return vt30;
    }

    public static VT30 getVt30Duplicate() {
        VT30 vt30 = getVt30();
        vt30.setCertificateIssuerInfo("Duplicate certificate issued by B. T. Arctor Tester1 on 13 February 2018");
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
            .setIssuedDate("2017-10-12")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("2010-10-12")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer(ODOMETER_VALUE + " " + MILES_ENGLISH)
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
            .setTestNumber("180681400628")
            .setEarliestDateOfTheNextTest(LocalDate.of(2018, 10, 13));

        vt30WithOverflownRFRs.setData(vt30WithOverflownRFRsData);
        return vt30WithOverflownRFRs;
    }

    public static VT20W getVt20W() {
        VT20W vt20W = new VT20W();
        vt20W.setDocumentName("MOT/VT20W");
        MotCertificateDataWelsh vt20WData = new MotCertificateDataWelsh();
        vt20WData
                .setEuMinorDefectsCy(generateRFRs(MINOR_RFR_WELSH_TEXT, 5))
                .setEuAdvisoryDefectsCy(generateRFRs(ADVISORY_RFR_WELSH_TEXT, 3))
                .setEuMinorDefects(generateRFRs(MINOR_RFR_TEXT, 5))
                .setEuAdvisoryDefects(generateRFRs(ADVISORY_RFR_TEXT, 3))
                .setMinorDefectsHeader(DefectSummaryComponent.MINOR_DEFECTS_HEADER_TEXT_WELSH)
                .setAdvisoryDefectsHeader(DefectSummaryComponent.ADVISORIES_HEADER_TEXT_WELSH)
                .setCountryOfRegistrationCode("GB")
                .setRawVin(VIN)
                .setIssuedDate("2017-10-12")
                .setDateOfTheTest(LocalDate.of(2017, 10, 12))
                .setExpiryDate("12.10.2018")
                .setDateOfTheExpiryTest("12.10.2018")
                .setFirstUseDate("2010-10-12")
                .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
                .setMake("Aston Martin")
                .setModel("DB11")
                .setTestClass("4")
                .setVehicleEuClassification("M1")
                .setRawVrm("KA1SAPH")
                .setOdometer(ODOMETER_VALUE + " " + MILES_ENGLISH)
                .setCurrentOdometer(
                        new OdometerReading("22341", "22341", "mi", LocalDate.now())
                )
                .setOdometerHistory("1 2 2016 200 miles\n 30 1 2017 300 miles")
                .setOdometerHistoryList(Arrays.asList(
                        new OdometerReading("120", "120", "km", LocalDate.of(2016, 2, 1)),
                        new OdometerReading("330", "330", "km", LocalDate.of(2017, 1, 30))
                ))
                .setIssuersName("R.DREWNO")
                .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
                .setAuthorisedExaminer("MILKE GROUP LIMITED")
                .setTestNumber("1806 8140 0628")
                .setEarliestDateOfTheNextTest(LocalDate.of(2018, 10, 13))
                .setAdditionalInformation("Not really used information");
        vt20W.setData(vt20WData);

        return vt20W;
    }

    public static VT30W getVt30W() {
        VT30W vt30W = new VT30W();
        vt30W.setDocumentName("MOT/VT30W");
        MotFailCertificateDataWelsh vt30WData = new MotFailCertificateDataWelsh();
        vt30WData
            .setEuAdvisoryDefectsCy(generateRFRs(ADVISORY_RFR_WELSH_TEXT, 3))
            .setEuDangerousDefectsCy(generateRFRs(DANGEROUS_RFR_WELSH_TEXT, 2))
            .setEuMajorDefectsCy(generateRFRs(MAJOR_RFR_WELSH_TEXT, 4))
            .setEuMinorDefectsCy(generateRFRs(MINOR_RFR_WELSH_TEXT, 5))

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
            .setIssuedDate("2017-10-12")
            .setDateOfTheTest(LocalDate.of(2017, 10, 12))
            .setExpiryDate("12.10.2018")
            .setFirstUseDate("2010-10-12")
            .setTestStationAddress("VTS004004 53, Call Road, Worthing BN12 6PB, United Kingdom")
            .setMake("Aston Martin")
            .setModel("DB11")
            .setTestClass("4")
            .setVehicleEuClassification("M1")
            .setRawVrm("KA1SAPH")
            .setOdometer(ODOMETER_VALUE + " " + MILES_ENGLISH)
            .setOdometerHistory("1 2 2014 450 miles\n 30 1 2017 500 miles")
            .setCurrentOdometer(
                new OdometerReading("22341", "22341", "mi", LocalDate.now())
            )
            .setOdometerHistoryList(Arrays.asList(
                new OdometerReading("300", "300","mi", LocalDate.of(2016, 02, 01)),
                new OdometerReading("600", "600", "mi", LocalDate.of(2017, 01, 30))
            ))
            .setIssuersName("R.DREWNO")
            .setInspectionAuthority("MILKE GROUP LIMITED R.DREWNO")
            .setAuthorisedExaminer("MILKE GROUP LIMITED")
            .setTestNumber("1806 8140 0628")
            .setEarliestDateOfTheNextTest(LocalDate.of(2018, 10, 13));
        vt30W.setData(vt30WData);

        return vt30W;
    }

    public static VT20W getVt20WDuplicate() {
        VT20W vt20W = getVt20W();
        vt20W.setCertificateIssuerInfoCy("Dyblyg wedi ei gyhoeddi gan B. T. Arctor Tester1 ar 22 Chwefror 2018");
        return vt20W;
    }

    public static VT30W getVt30WDuplicate() {
        VT30W vt30W = getVt30W();
        vt30W.setCertificateIssuerInfoCy("Dyblyg wedi ei gyhoeddi gan B. T. Arctor Tester1 ar 22 Chwefror 2018");
        return vt30W;
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
