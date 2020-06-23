package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonProperty;

class Weight {

    @JsonProperty("GbWeight")
    private int gbWeight;

    @JsonProperty("DesignWeight")
    private int designWeight;

    @JsonProperty("EecWeight")
    private int eecWeight;

    public Weight() {
    }

    public Weight(int gbWeight, int designWeight, int eecWeight) {
        this.gbWeight = gbWeight;
        this.designWeight = designWeight;
        this.eecWeight = eecWeight;
    }

    public int getGbWeight() {
        return gbWeight;
    }

    public void setGbWeight(int gbWeight) {
        this.gbWeight = gbWeight;
    }

    public int getDesignWeight() {
        return designWeight;
    }

    public void setDesignWeight(int designWeight) {
        this.designWeight = designWeight;
    }

    public int getEecWeight() {
        return eecWeight;
    }

    public void setEecWeight(int eecWeight) {
        this.eecWeight = eecWeight;
    }
}

class Tyre {

    @JsonProperty("TyreSize")
    private String tyreSize;

    @JsonProperty("PlyRating")
    private String plyRating;

    @JsonProperty("FitmentCode")
    private String fitmentCode;

    public Tyre() {
    }

    public Tyre(String tyreSize, String plyRating, String fitmentCode) {
        this.tyreSize = tyreSize;
        this.plyRating = plyRating;
        this.fitmentCode = fitmentCode;
    }

    public String getTyreSize() {
        return tyreSize;
    }

    public void setTyreSize(String tyreSize) {
        this.tyreSize = tyreSize;
    }

    public String getPlyRating() {
        return plyRating;
    }

    public void setPlyRating(String plyRating) {
        this.plyRating = plyRating;
    }

    public String getFitmentCode() {
        if (this.fitmentCode.equals("double")) {
            return "D";
        } else {
            return "S";
        }
    }

    public void setFitmentCode(String fitmentCode) {
        this.fitmentCode = fitmentCode;
    }
}

class Axle {

    @JsonProperty("Weights")
    private Weight weights;

    @JsonProperty("Tyres")
    private Tyre tyres;

    public Axle() {
    }

    public Axle(Weight weights, Tyre tyres) {
        this.weights = weights;
        this.tyres = tyres;
    }

    public Weight getWeights() {
        return weights;
    }

    public void setWeights(Weight weights) {
        this.weights = weights;
    }

    public Tyre getTyres() {
        return tyres;
    }

    public void setTyres(Tyre tyres) {
        this.tyres = tyres;
    }
}

public class Axles {

    @JsonProperty("Axle1")
    private Axle axle1;

    @JsonProperty("Axle2")
    private Axle axle2;

    @JsonProperty("Axle3")
    private Axle axle3;

    @JsonProperty("Axle4")
    private Axle axle4;

    public Axles() {
    }

    public Axles(Axle axle1, Axle axle2, Axle axle3, Axle axle4) {
        this.axle1 = axle1;
        this.axle2 = axle2;
        this.axle3 = axle3;
        this.axle4 = axle4;
    }

    public Axle getAxle1() {
        return axle1;
    }

    public void setAxle1(Axle axle1) {
        this.axle1 = axle1;
    }

    public Axle getAxle2() {
        return axle2;
    }

    public void setAxle2(Axle axle2) {
        this.axle2 = axle2;
    }

    public Axle getAxle3() {
        return axle3;
    }

    public void setAxle3(Axle axle3) {
        this.axle3 = axle3;
    }

    public Axle getAxle4() {
        return axle4;
    }

    public void setAxle4(Axle axle4) {
        this.axle4 = axle4;
    }
}
