package uk.gov.dvsa.model.mot.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.mot.results.DefectsList;
import uk.gov.dvsa.model.mot.results.Summary;
import uk.gov.dvsa.view.mot.CountryCodeFormatter;
import uk.gov.dvsa.view.mot.OdometerReadingFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MotCertificateData {

    public static final String EU_NUMBER_FOR_DEFECTS = "6";

    private static final String ADVISORIES_HEADER = "Monitor and repair if necessary (advisories)";
    private static final String MINOR_DEFECTS_HEADER = "Repair as soon as possible (minor defects)";
    public static final String PASS_SUMMARY_HEADER = "Pass";
    public static final String PASS_WITH_DEFECTS_HEADER = "Pass with defects";
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final OdometerReadingFormatter ODOMETER_FORMATTER =  new OdometerReadingFormatter();
    private static final CountryCodeFormatter COUNTRY_CODE_FORMATTER = new CountryCodeFormatter();
    private static final String TEST_NUMBER_PATTERN = "\\B(?=(?:.{4})+$)";
    private static final String TEST_NUMBER_SEPARATOR = " ";

    @JsonProperty("dup")
    private String duplicateMode;

    @JsonProperty("TestNumber")
    private String testNumber;

    @JsonProperty("TestStation")
    private String testStation;

    @JsonProperty("TestStationAddress")
    private String testStationAddress;

    @JsonProperty("InspectionAuthority")
    private String inspectionAuthority;

    @JsonProperty("AuthorisedExaminer")
    private String authorisedExaminer;

    @JsonProperty("IssuedDate")
    private String issuedDate;

    @JsonProperty("IssuersName")
    private String issuersName;

    @JsonProperty("VRM")
    private String vrm;

    @JsonProperty("RawVRM")
    private String rawVrm;

    @JsonProperty("VIN")
    private String vin;

    @JsonProperty("RawVIN")
    private String rawVin;

    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("CountryOfRegistration")
    private String countryOfRegistration;

    @JsonProperty("CountryOfRegistrationCode")
    private String countryOfRegistrationCode;

    @JsonProperty("TestClass")
    private String testClass;

    @JsonProperty("VehicleEuClassification")
    private String vehicleEuClassification;

    @JsonProperty("Colour")
    private String colour;

    @JsonProperty("Odometer")
    private String odometer;

    @JsonProperty("CurrentOdometer")
    private OdometerReading currentOdometer;

    @JsonProperty("OdometerUnit")
    private String odometerUnit;

    @JsonProperty("OdometerHistory")
    private String odometerHistory;

    @JsonProperty("FirstUseDate")
    private String firstUseDate;

    @JsonProperty("ExpiryDate")
    private String expiryDate;

    @JsonProperty("DateOfTheTest")
    private LocalDate dateOfTheTest;

    @JsonProperty("AdvisoryInformation")
    private String advisoryInformation;

    @JsonProperty("EuAdvisoryDefects")
    private List<String> euAdvisoryDefects;

    @JsonProperty("AdditionalInformation")
    private String additionalInformation;

    @JsonProperty("AdvisoryDefectsHeader")
    private String advisoryDefectsHeader;

    @JsonProperty("OdometerHistoryList")
    private List<OdometerReading> odometerHistoryList;

    @JsonProperty("DateOfTheExpiryTest")
    private String dateOfTheExpiryTest;

    @JsonProperty("MinorDefectsHeader")
    private String minorDefectsHeader;

    @JsonProperty("MinorDefects")
    private String oldMinorDefects;

    @JsonProperty("EarliestDateOfTheNextTest")
    private LocalDate earliestDateOfTheNextTest;

    @JsonProperty("EuMinorDefects")
    private List<String> euMinorDefects;

    public String getDuplicateMode() {
        return duplicateMode;
    }

    public MotCertificateData setDuplicateMode(String duplicateMode) {
        this.duplicateMode = duplicateMode;
        return this;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public String getFormattedTestNumber() {
        return testNumber
                .replace(TEST_NUMBER_SEPARATOR, "")
                .replaceAll(TEST_NUMBER_PATTERN, TEST_NUMBER_SEPARATOR);
    }

    public MotCertificateData setTestNumber(String testNumber) {
        this.testNumber = testNumber;
        return this;
    }

    public String getTestStation() {
        return testStation;
    }

    public MotCertificateData setTestStation(String testStation) {
        this.testStation = testStation;
        return this;
    }

    public String getInspectionAuthority() {
        return inspectionAuthority;
    }

    public MotCertificateData setInspectionAuthority(String inspectionAuthority) {
        this.inspectionAuthority = inspectionAuthority;
        return this;
    }

    public String getOdometer() {
        return odometer;
    }

    public MotCertificateData setOdometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public OdometerReading getCurrentOdometer() {
        return currentOdometer;
    }

    public String getFormattedCurrentOdometer() {
        return ODOMETER_FORMATTER.formatValue(currentOdometer);
    }

    public MotCertificateData setCurrentOdometer(OdometerReading currentOdometer) {
        this.currentOdometer = currentOdometer;
        return this;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public MotCertificateData setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
        return this;
    }

    public String getIssuersName() {
        return issuersName;
    }

    public MotCertificateData setIssuersName(String issuersName) {
        this.issuersName = issuersName;
        return this;
    }

    public String getVrm() {
        return vrm;
    }

    public MotCertificateData setVrm(String vrm) {
        this.vrm = vrm;
        return this;
    }

    public String getRawVrm() {
        return rawVrm;
    }

    public MotCertificateData setRawVrm(String rawVrm) {
        this.rawVrm = rawVrm;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public MotCertificateData setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getRawVin() {
        return rawVin;
    }

    public MotCertificateData setRawVin(String rawVin) {
        this.rawVin = rawVin;
        return this;
    }

    public String getMake() {
        return make;
    }

    public MotCertificateData setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MotCertificateData setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCountryOfRegistration() {
        return countryOfRegistration;
    }

    public MotCertificateData setCountryOfRegistration(String countryOfRegistration) {
        this.countryOfRegistration = countryOfRegistration;
        return this;
    }

    public String getTestClass() {
        return testClass;
    }

    public MotCertificateData setTestClass(String testClass) {
        this.testClass = testClass;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public MotCertificateData setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public String getOdometerHistory() {
        return odometerHistory;
    }

    public MotCertificateData setOdometerHistory(String odometerHistory) {
        this.odometerHistory = odometerHistory;
        return this;
    }

    public String getFirstUseDate() {
        return firstUseDate;
    }

    public MotCertificateData setFirstUseDate(String firstUseDate) {
        this.firstUseDate = firstUseDate;
        return this;
    }

    public MotCertificateData setAdvisoryInformation(String advisoryInformation) {
        this.advisoryInformation = advisoryInformation;
        return this;
    }

    public MotCertificateData setEuAdvisoryDefects(List<String> euAdvisoryDefects) {
        this.euAdvisoryDefects = euAdvisoryDefects;
        return this;
    }

    public List<String> getEuAdvisoryDefects() {
        return this.euAdvisoryDefects;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public MotCertificateData setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public MotCertificateData setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public String getTestStationAddress() {
        return testStationAddress;
    }

    public String getTestStationAddressLine() {
        return testStationAddress.replace("\n", ", ");
    }

    public MotCertificateData setTestStationAddress(String testStationAddress) {
        this.testStationAddress = testStationAddress;
        return this;
    }

    public String getAdvisoryDefectsHeader() {
        return advisoryDefectsHeader;
    }

    public MotCertificateData setAdvisoryDefectsHeader(String advisoryDefectsHeader) {
        this.advisoryDefectsHeader = advisoryDefectsHeader;
        return this;
    }

    public String getOdometerUnit() {
        return odometerUnit;
    }

    public void setOdometerUnit(String odometerUnit) {
        this.odometerUnit = odometerUnit;
    }

    public LocalDate getDateOfTheTest() {
        return dateOfTheTest;
    }

    public MotCertificateData setDateOfTheTest(LocalDate dateOfTheTest) {
        this.dateOfTheTest = dateOfTheTest;
        return this;
    }

    public String getCountryOfRegistrationCode() {
        return countryOfRegistrationCode;
    }

    public String getCountryOfRegistrationCodeFormatted() {
        return COUNTRY_CODE_FORMATTER.format(countryOfRegistrationCode);
    }

    public MotCertificateData setCountryOfRegistrationCode(String countryOfRegistrationCode) {
        this.countryOfRegistrationCode = countryOfRegistrationCode;
        return this;
    }

    public String getVehicleEuClassification() {
        return vehicleEuClassification;
    }

    public MotCertificateData setVehicleEuClassification(String vehicleEuClassification) {
        this.vehicleEuClassification = vehicleEuClassification;
        return this;
    }

    public List<OdometerReading> getOdometerHistoryList() {
        return odometerHistoryList;
    }

    public List<FormattedOdometerReading> getMileageHistory() {
        if (null != odometerHistoryList) {
            return odometerHistoryList.stream()
                .map(
                    entry -> new FormattedOdometerReading(
                        ODOMETER_FORMATTER.formatValue(entry),
                        DATE_FORMATTER.format(entry.getDate())
                    )
                )
                .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public MotCertificateData setOdometerHistoryList(List<OdometerReading> odometerHistoryList) {
        this.odometerHistoryList = odometerHistoryList;
        return this;
    }

    public String getDateOfTheExpiryTest() {
        return dateOfTheExpiryTest;
    }

    public MotCertificateData setDateOfTheExpiryTest(String dateOfTheExpiryTest) {
        this.dateOfTheExpiryTest = dateOfTheExpiryTest;
        return this;
    }

    public String getFormattedDateOfTheTest() {
        return Optional.ofNullable(dateOfTheTest)
                .map(date -> date.format(DATE_FORMATTER))
                .orElse("");
    }

    public String getAuthorisedExaminer() {
        return authorisedExaminer;
    }

    public MotCertificateData setAuthorisedExaminer(String authorisedExaminer) {
        this.authorisedExaminer = authorisedExaminer;
        return this;
    }

    public MotCertificateData setEuMinorDefects(List<String> euMinorDefects) {
        this.euMinorDefects = euMinorDefects;
        return this;
    }

    public List<String> getEuMinorDefects() {
        return this.euMinorDefects;
    }

    public String getMinorDefectsHeader() {
        return minorDefectsHeader;
    }

    public MotCertificateData setMinorDefectsHeader(String minorDefectsHeader) {
        this.minorDefectsHeader = minorDefectsHeader;
        return this;
    }

    public MotCertificateData setOldMinorDefects(String oldMinorDefects) {
        this.oldMinorDefects = oldMinorDefects;
        return this;
    }

    public LocalDate getEarliestDateOfTheNextTest() {
        return earliestDateOfTheNextTest;
    }

    public MotCertificateData setEarliestDateOfTheNextTest(LocalDate earliestDateOfTheNextTest) {
        this.earliestDateOfTheNextTest = earliestDateOfTheNextTest;
        return this;
    }

    public String getFormattedEarliestDateOfTheNextTest() {
        return Optional.ofNullable(earliestDateOfTheNextTest)
                .map(date -> date.format(DATE_FORMATTER))
                .orElseThrow(() -> new RuntimeException("The earliest date of the next test is missing."));
    }

    public DefectsList getAdvisory() {
        return new DefectsList(ADVISORIES_HEADER, this.euAdvisoryDefects);
    }

    public DefectsList getMinor() {
        return new DefectsList(MINOR_DEFECTS_HEADER, this.euMinorDefects, EU_NUMBER_FOR_DEFECTS);

    }

    public Summary getSummary() {
        return new Summary(buildSummaryTitle());
    }

    private String buildSummaryTitle() {
        if (!hasMinorDefects(getEuMinorDefects())) {
            return PASS_SUMMARY_HEADER;
        } else {
            return PASS_WITH_DEFECTS_HEADER;
        }
    }

    public boolean hasMinorDefects(List<String> minorDefects) {
        return minorDefects != null && !minorDefects.isEmpty();
    }
}
