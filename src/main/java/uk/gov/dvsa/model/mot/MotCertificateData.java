package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public class MotCertificateData {
    @JsonProperty("dup")
    private String duplicateMode;

    @JsonProperty("TestNumber")
    private String testNumber;

    @JsonProperty("TestStation")
    private String testStation;

    @JsonProperty("InspectionAuthority")
    private String inspectionAuthority;

    @JsonProperty("Odometer")
    private String odometer;

    @JsonProperty("IssuedDate")
    private String issuedDate;

    @JsonProperty("IssuersName")
    private String issuersName;

    @JsonProperty("VRM")
    private String vrm;

    @JsonProperty("VIN")
    private String vin;

    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("CountryOfRegistration")
    private String countryOfRegistration;

    @JsonProperty("TestClass")
    private String testClass;

    @JsonProperty("Colour")
    private String colour;

    @JsonProperty("OdometerHistory")
    private String odometerHistory;

    @JsonProperty("FirstUseDate")
    private String firstUseDate;

    @JsonProperty("AdvisoryInformation")
    private String advisoryInformation;

    @JsonProperty("ExpiryDate")
    private String expiryDate;

    @JsonProperty("AdditionalInformation")
    private String additionalInformation;

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

    public String getVin() {
        return vin;
    }

    public MotCertificateData setVin(String vin) {
        this.vin = vin;
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

    public String getAdvisoryInformation() {
        return advisoryInformation;
    }

    public MotCertificateData setAdvisoryInformation(String advisoryInformation) {
        this.advisoryInformation = advisoryInformation;
        return this;
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
}
