package uk.gov.dvsa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Document {

    private String documentName;

    @JsonProperty("Watermark")
    private String watermark;

    public String getWatermark() {
        return watermark;
    }

    public Document setWatermark(String watermark) {
        this.watermark = watermark;
        return this;
    }

    public String getDocumentName() {
        return documentName;
    }

    public Document setDocumentName(String documentName) {
        this.documentName = documentName;
        return this;
    }
}
