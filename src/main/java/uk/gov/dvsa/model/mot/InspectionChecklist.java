package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public class InspectionChecklist extends Document {

    @JsonProperty("Tester")
    private String testerName;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Time")
    private String time;

    @JsonProperty("VTS")
    private String vts;

    @JsonProperty("Registration")
    private String registrationMark;

    @JsonProperty("VIN")
    private String vin;

    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("EUCategory")
    private String euCategory;

    @JsonProperty("CylinderCapacity")
    private String cylinderCapacity;

    @JsonProperty("FirstUse")
    private String firstUse;

    @JsonProperty("BrakeWeight")
    private String brakeWeight;

    public String getTesterName() {
        return testerName;
    }

    public InspectionChecklist setTesterName(String testerName) {

        this.testerName = testerName;
        return this;
    }

    public String getDate() {
        return date;
    }

    public InspectionChecklist setDate(String date) {

        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public InspectionChecklist setTime(String time) {

        this.time = time;
        return this;
    }

    public String getVts() {
        return vts;
    }

    public InspectionChecklist setVts(String vts) {

        this.vts = vts;
        return this;
    }

    public String getRegistrationMark() {
        return registrationMark;
    }

    public InspectionChecklist setRegistrationMark(String registrationMark) {

        this.registrationMark = registrationMark;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public InspectionChecklist setVin(String vin) {

        this.vin = vin;
        return this;
    }

    public String getMake() {
        return make;
    }

    public InspectionChecklist setMake(String make) {

        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public InspectionChecklist setModel(String model) {

        this.model = model;
        return this;
    }

    public String getEuCategory() {
        return euCategory;
    }

    public InspectionChecklist setEuCategory(String euCategory) {

        this.euCategory = euCategory;
        return this;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public InspectionChecklist setCylinderCapacity(String cylinderCapacity) {

        this.cylinderCapacity = cylinderCapacity;
        return this;
    }

    public String getFirstUse() {
        return firstUse;
    }

    public InspectionChecklist setFirstUse(String firstUse) {

        this.firstUse = firstUse;
        return this;
    }

    public String getBrakeWeight() {
        return brakeWeight;
    }

    public InspectionChecklist setBrakeWeight(String brakeWeight) {
        this.brakeWeight = brakeWeight;
        return this;
    }

    public String getMakeAndModel(){

        if (this.make == null) {
            this.make = "";
        }

        if (this.model == null) {
            this.model = "";
        }

        String concatString = this.make + " " + this.model;

        if (concatString.length() > 40) {
            return concatString.substring(0, 40);
        }

        return concatString;
    }
}