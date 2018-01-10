package uk.gov.dvsa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VT20Certificate extends Document {
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

    @JsonProperty("FailureInformation")
    private String failureInformation;

    @JsonProperty("AdvisoryInformation")
    private String advisoryInformation;

    @JsonProperty("ExpiryDate")
    private String expiryDate;

    @JsonProperty("AdditionalInformation")
    private String additionalInformation;

    public String getDuplicateMode() {
        return duplicateMode;
    }

    public VT20Certificate setDuplicateMode(String duplicateMode) {
        this.duplicateMode = duplicateMode;
        return this;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public VT20Certificate setTestNumber(String testNumber) {
        this.testNumber = testNumber;
        return this;
    }

    public String getTestStation() {
        return testStation;
    }

    public VT20Certificate setTestStation(String testStation) {
        this.testStation = testStation;
        return this;
    }

    public String getInspectionAuthority() {
        return inspectionAuthority;
    }

    public VT20Certificate setInspectionAuthority(String inspectionAuthority) {
        this.inspectionAuthority = inspectionAuthority;
        return this;
    }

    public String getOdometer() {
        return odometer;
    }

    public VT20Certificate setOdometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public VT20Certificate setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
        return this;
    }

    public String getIssuersName() {
        return issuersName;
    }

    public VT20Certificate setIssuersName(String issuersName) {
        this.issuersName = issuersName;
        return this;
    }

    public String getVrm() {
        return vrm;
    }

    public VT20Certificate setVrm(String vrm) {
        this.vrm = vrm;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public VT20Certificate setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getMake() {
        return make;
    }

    public VT20Certificate setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VT20Certificate setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCountryOfRegistration() {
        return countryOfRegistration;
    }

    public VT20Certificate setCountryOfRegistration(String countryOfRegistration) {
        this.countryOfRegistration = countryOfRegistration;
        return this;
    }

    public String getTestClass() {
        return testClass;
    }

    public VT20Certificate setTestClass(String testClass) {
        this.testClass = testClass;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public VT20Certificate setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public String getOdometerHistory() {
        return odometerHistory;
    }

    public VT20Certificate setOdometerHistory(String odometerHistory) {
        this.odometerHistory = odometerHistory;
        return this;
    }

    public String getFirstUseDate() {
        return firstUseDate;
    }

    public VT20Certificate setFirstUseDate(String firstUseDate) {
        this.firstUseDate = firstUseDate;
        return this;
    }

    public String getFailureInformation() {
        return failureInformation;
    }

    public VT20Certificate setFailureInformation(String failureInformation) {
        this.failureInformation = failureInformation;
        return this;
    }

    public String getAdvisoryInformation() {
        return advisoryInformation;
    }

    public VT20Certificate setAdvisoryInformation(String advisoryInformation) {
        this.advisoryInformation = advisoryInformation;
        return this;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public VT20Certificate setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public VT20Certificate setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }
}
