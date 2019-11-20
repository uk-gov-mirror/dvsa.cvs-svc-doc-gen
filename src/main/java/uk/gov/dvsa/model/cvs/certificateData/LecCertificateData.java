package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LecCertificateData {
    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("SerialNumber")
    private String serialNumber;

    @JsonProperty("ExpiryDate")
    private String expiryDate;

    @JsonProperty("VRM")
    private String vrm;

    @JsonProperty("VIN")
    private String vin;

    @JsonProperty("PrescribedEmissionStandard")
    private String prescribedEmissionStandard;

    @JsonProperty("ParticulateTrapFitted")
    private String particulateTrapFitted;

    @JsonProperty("ParticulateTrapSerialNumber")
    private String particulateTrapSerialNumber;

    @JsonProperty("ModificationTypeUsed")
    private String modificationTypeUsed;

    @JsonProperty("ModificationType")
    private String modificationType;

    @JsonProperty("SmokeTestLimit")
    private String smokeTestLimit;

    @JsonProperty("AdditionalNotesRequired")
    private String additionalNotes;

    @JsonProperty("DateOfTheTest")
    private String testDate;

    @JsonProperty("TestStationName")
    private String testStationName;

    @JsonProperty("TestStationPNumber")
    private String testStationPNumber;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getVrm() {
        return vrm;
    }

    public void setVrm(String vrm) {
        this.vrm = vrm;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPrescribedEmissionStandard() {
        return prescribedEmissionStandard;
    }

    public void setPrescribedEmissionStandard(String prescribedEmissionStandard) {
        this.prescribedEmissionStandard = prescribedEmissionStandard;
    }

    public String getParticulateTrapFitted() {
        return particulateTrapFitted;
    }

    public void setParticulateTrapFitted(String particulateTrapFitted) {
        this.particulateTrapFitted = particulateTrapFitted;
    }

    public String getParticulateTrapSerialNumber() {
        return particulateTrapSerialNumber;
    }

    public void setParticulateTrapSerialNumber(String particulateTrapSerialNumber) {
        this.particulateTrapSerialNumber = particulateTrapSerialNumber;
    }

    public String getModificationTypeUsed() {
        return modificationTypeUsed;
    }

    public void setModificationTypeUsed(String modificationTypeUsed) {
        this.modificationTypeUsed = modificationTypeUsed;
    }

    public String getModificationType() {
        return modificationType;
    }

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }
    public boolean getModificationTypeP() {
        return this.modificationType.equals("P");
    }
    public boolean getModificationTypeM() {
        return this.modificationType.equals("M");
    }

    public boolean getModificationTypeG() {
        return this.modificationType.equals("G");
    }

    public String getSmokeTestLimit() {
        return smokeTestLimit;
    }

    public void setSmokeTestLimit(String smokeTestLimit) {
        this.smokeTestLimit = smokeTestLimit;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getTestStationName() {
        return testStationName;
    }

    public void setTestStationName(String testStationName) {
        this.testStationName = testStationName;
    }

    public String getTestStationPNumber() {
        return testStationPNumber;
    }

    public void setTestStationPNumber(String testStationPNumber) {
        this.testStationPNumber = testStationPNumber;
    }

    public String getParticulateTrapFittedOrModificationTypeUsed() {
        return "P".equals(this.modificationType) ? this.particulateTrapFitted : this.modificationTypeUsed;
    }

}
