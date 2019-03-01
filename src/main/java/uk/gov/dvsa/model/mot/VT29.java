package uk.gov.dvsa.model.mot;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvsa.model.Document;

public class VT29 extends Document {

    @JsonProperty("Vrm")
    private String vrm;

    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("TestNumber")
    private String testNumber;

    @JsonProperty("Vin")
    private String vin;

    @JsonProperty("DateOfFirstUse")
    private String dateOfFirstUse;

    public String getVrm() {
        return vrm;
    }

    public VT29 setVrm(String vrm) {
        this.vrm = vrm;
        return this;
    }

    public String getMake() {
        return make;
    }

    public VT29 setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VT29 setModel(String model) {
        this.model = model;
        return this;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public VT29 setTestNumber(String testNumber) {
        this.testNumber = testNumber;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public VT29 setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getDateOfFirstUse() {
        return dateOfFirstUse;
    }

    public VT29 setDateOfFirstUse(String dateOfFirstUse) {
        this.dateOfFirstUse = dateOfFirstUse;
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
