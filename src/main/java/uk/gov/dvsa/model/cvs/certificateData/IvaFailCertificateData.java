package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IvaFailCertificateData {
    @JsonProperty("serialNumber")
    private String serialNo;
    @JsonProperty("vehicleTrailerNrNo")
    private String vehicleTrailerNrNo;
    @JsonProperty("testCategoryClass")
    private String testCategoryClass;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("testCategoryBasicNormal")
    private String testCategoryBasicNormal;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("bodyType")
    private String bodyType;
    @JsonProperty("date")
    private String date;
    @JsonProperty("reapplicationDate")
    private String reapplicationDate;
    @JsonProperty("station")
    private String station;
    @JsonProperty("testerName")
    private String testerName;
    @JsonProperty("additionalDefects")
    private AdditionalDefect[] additionalDefects;
    @JsonProperty("requiredStandards")
    private RequiredStandard[] requiredStandards;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getVehicleTrailerNrNo() {
        return vehicleTrailerNrNo;
    }

    public void setVehicleTrailerNrNo(String vehicleTrailerNrNo) {
        this.vehicleTrailerNrNo = vehicleTrailerNrNo;
    }

    public String getTestCategoryClass() {
        return testCategoryClass;
    }

    public void setTestCategoryClass(String testCategoryClass) {
        this.testCategoryClass = testCategoryClass;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTestCategoryBasicNormal() {
        return testCategoryBasicNormal;
    }

    public void setTestCategoryBasicNormal(String testCategoryBasicNormal) {
        this.testCategoryBasicNormal = testCategoryBasicNormal;
    }

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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReapplicationDate() {
        return reapplicationDate;
    }

    public void setReapplicationDate(String reapplicationDate) {
        this.reapplicationDate = reapplicationDate;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public AdditionalDefect[] getAdditionalDefects() {
        return additionalDefects;
    }

    public void setAdditionalDefects(AdditionalDefect[] additionalDefects) {
        this.additionalDefects = additionalDefects;
    }

    public RequiredStandard[] getRequiredStandards() {
        return requiredStandards;
    }

    public void setRequiredStandards(RequiredStandard[] requiredStandards) {
        this.requiredStandards = requiredStandards;
    }
}
