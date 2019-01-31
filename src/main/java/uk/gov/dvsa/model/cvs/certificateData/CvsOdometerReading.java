package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CvsOdometerReading {
    @JsonProperty
    private String value;

    @JsonProperty
    private String unit;

    @JsonProperty
    private String date;

    public CvsOdometerReading() {
    }

    public CvsOdometerReading(String value, String unit, String date) {
        this.value = value;
        this.unit = unit;
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public CvsOdometerReading setValue(String value) {
        this.value = value;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public CvsOdometerReading setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CvsOdometerReading setDate(String date) {
        this.date = date;
        return this;
    }
}
