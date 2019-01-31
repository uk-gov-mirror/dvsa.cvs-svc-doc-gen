package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Signature {

    @JsonProperty("ImageType")
    private String imageType;

    @JsonProperty("ImageData")
    private String imageData;

    public String getImageType() {
        return imageType;
    }

    public Signature setImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    public String getImageData() {
        return imageData;
    }

    public Signature setImageData(String imageData) {
        this.imageData = imageData;
        return this;
    }

    public String getFormattedImageData() {
        return "data:image/" + this.getImageType() + ";base64," + this.getImageData();
    }
}
