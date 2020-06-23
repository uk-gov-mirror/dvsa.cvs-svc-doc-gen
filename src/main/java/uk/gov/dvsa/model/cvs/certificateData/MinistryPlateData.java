package uk.gov.dvsa.model.cvs.certificateData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MinistryPlateData {

    @JsonProperty("PlateSerialNumber")
    private String plateSerialNumber;

    @JsonProperty("DtpNumber")
    private String dtpNumber;

    @JsonProperty("PrimaryVrm")
    private String primaryVrm;

    @JsonProperty("Vin")
    private String vin;

    @JsonProperty("VariantNumber")
    private String variantNumber;

    @JsonProperty("ApprovalTypeNumber")
    private String approvalTypeNumber;

    @JsonProperty("Make")
    private String make;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("SpeedLimiterMrk")
    private boolean speedLimiterMrk;

    @JsonProperty("FunctionCode")
    private String functionCode;

    @JsonProperty("RegnDate")
    private String regnDate;

    @JsonProperty("ManufactureYear")
    private int manufactureYear;

    @JsonProperty("GrossGbWeight")
    private int grossGbWeight;

    @JsonProperty("GrossEecWeight")
    private int grossEecWeight;

    @JsonProperty("GrossDesignWeight")
    private int grossDesignWeight;

    @JsonProperty("TrainGbWeight")
    private int trainGbWeight;

    @JsonProperty("TrainEecWeight")
    private int trainEecWeight;

    @JsonProperty("TrainDesignWeight")
    private int trainDesignWeight;

    @JsonProperty("MaxTrainGbWeight")
    private int maxTrainGbWeight;

    @JsonProperty("MaxTrainEecWeight")
    private int maxTrainEecWeight;

    @JsonProperty("MaxLoadOnCoupling")
    private int maxLoadOnCoupling;

    @JsonProperty("FrontAxleTo5thWheelCouplingMin")
    private int frontAxleTo5thWheelCouplingMin;

    @JsonProperty("FrontAxleTo5thWheelCouplingMax")
    private int frontAxleTo5thWheelCouplingMax;

    @JsonProperty("CouplingCenterToRearTrlMax")
    private int couplingCenterToRearTrlMax;

    @JsonProperty("CouplingCenterToRearTrlMin")
    private int couplingCenterToRearTrlMin;

    @JsonProperty("PlateIssueDate")
    private String plateIssueDate;

    @JsonProperty("TyreUseCode")
    private String tyreUseCode;

    @JsonProperty("DimensionLength")
    private int dimensionLength;

    @JsonProperty("DimensionWidth")
    private int dimensionWidth;

    @JsonProperty("Axles")
    private Axles axles;

    public String getPlateSerialNumber() {
        return plateSerialNumber;
    }

    public MinistryPlateData setPlateSerialNumber(String plateSerialNumber) {
        this.plateSerialNumber = plateSerialNumber;
        return this;
    }

    public String getDtpNumber() {
        return dtpNumber;
    }

    public MinistryPlateData setDtpNumber(String dtpNumber) {
        this.dtpNumber = dtpNumber;
        return this;
    }

    public String getPrimaryVrm() {
        return primaryVrm;
    }

    public MinistryPlateData setPrimaryVrm(String primaryVrm) {
        this.primaryVrm = primaryVrm;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public MinistryPlateData setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getVariantNumber() {
        return variantNumber;
    }

    public MinistryPlateData setVariantNumber(String variantNumber) {
        this.variantNumber = variantNumber;
        return this;
    }

    public String getApprovalTypeNumber() {
        return approvalTypeNumber;
    }

    public MinistryPlateData setApprovalTypeNumber(String approvalTypeNumber) {
        this.approvalTypeNumber = approvalTypeNumber;
        return this;
    }

    public String getMake() {
        return make;
    }

    public MinistryPlateData setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MinistryPlateData setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSpeedLimiterMrk() {
        if (this.speedLimiterMrk) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public MinistryPlateData setSpeedLimiterMrk(boolean speedLimiterMrk) {
        this.speedLimiterMrk = speedLimiterMrk;
        return this;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public MinistryPlateData setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
        return this;
    }

    public String getRegnDate() {
        return regnDate;
    }

    public MinistryPlateData setRegnDate(String regnDate) {
        this.regnDate = regnDate;
        return this;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public MinistryPlateData setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
        return this;
    }

    public int getGrossGbWeight() {
        return grossGbWeight;
    }

    public MinistryPlateData setGrossGbWeight(int grossGbWeight) {
        this.grossGbWeight = grossGbWeight;
        return this;
    }

    public int getGrossEecWeight() {
        return grossEecWeight;
    }

    public MinistryPlateData setGrossEecWeight(int grossEecWeight) {
        this.grossEecWeight = grossEecWeight;
        return this;
    }

    public int getGrossDesignWeight() {
        return grossDesignWeight;
    }

    public MinistryPlateData setGrossDesignWeight(int grossDesignWeight) {
        this.grossDesignWeight = grossDesignWeight;
        return this;
    }

    public int getTrainGbWeight() {
        return trainGbWeight;
    }

    public MinistryPlateData setTrainGbWeight(int trainGbWeight) {
        this.trainGbWeight = trainGbWeight;
        return this;
    }

    public int getTrainEecWeight() {
        return trainEecWeight;
    }

    public MinistryPlateData setTrainEecWeight(int trainEecWeight) {
        this.trainEecWeight = trainEecWeight;
        return this;
    }

    public int getTrainDesignWeight() {
        return trainDesignWeight;
    }

    public MinistryPlateData setTrainDesignWeight(int trainDesignWeight) {
        this.trainDesignWeight = trainDesignWeight;
        return this;
    }

    public int getMaxTrainGbWeight() {
        return maxTrainGbWeight;
    }

    public MinistryPlateData setMaxTrainGbWeight(int maxTrainGbWeight) {
        this.maxTrainGbWeight = maxTrainGbWeight;
        return this;
    }

    public int getMaxTrainEecWeight() {
        return maxTrainEecWeight;
    }

    public MinistryPlateData setMaxTrainEecWeight(int maxTrainEecWeight) {
        this.maxTrainEecWeight = maxTrainEecWeight;
        return this;
    }

    public int getMaxLoadOnCoupling() {
        return maxLoadOnCoupling;
    }

    public MinistryPlateData setMaxLoadOnCoupling(int maxLoadOnCoupling) {
        this.maxLoadOnCoupling = maxLoadOnCoupling;
        return this;
    }

    public int getFrontAxleTo5thWheelCouplingMin() {
        return frontAxleTo5thWheelCouplingMin;
    }

    public MinistryPlateData setFrontAxleTo5thWheelCouplingMin(int frontAxleTo5thWheelCouplingMin) {
        this.frontAxleTo5thWheelCouplingMin = frontAxleTo5thWheelCouplingMin;
        return this;
    }

    public int getFrontAxleTo5thWheelCouplingMax() {
        return frontAxleTo5thWheelCouplingMax;
    }

    public MinistryPlateData setFrontAxleTo5thWheelCouplingMax(int frontAxleTo5thWheelCouplingMax) {
        this.frontAxleTo5thWheelCouplingMax = frontAxleTo5thWheelCouplingMax;
        return this;
    }

    public int getCouplingCenterToRearTrlMax() {
        return couplingCenterToRearTrlMax;
    }

    public MinistryPlateData setCouplingCenterToRearTrlMax(int couplingCenterToRearTrlMax) {
        this.couplingCenterToRearTrlMax = couplingCenterToRearTrlMax;
        return this;
    }

    public int getCouplingCenterToRearTrlMin() {
        return couplingCenterToRearTrlMin;
    }

    public MinistryPlateData setCouplingCenterToRearTrlMin(int couplingCenterToRearTrlMin) {
        this.couplingCenterToRearTrlMin = couplingCenterToRearTrlMin;
        return this;
    }

    public String getPlateIssueDate() {
        return plateIssueDate;
    }

    public MinistryPlateData setPlateIssueDate(String plateIssueDate) {
        this.plateIssueDate = plateIssueDate;
        return this;
    }

    public String getTyreUseCode() {
        return tyreUseCode;
    }

    public MinistryPlateData setTyreUseCode(String tyreUseCode) {
        this.tyreUseCode = tyreUseCode;
        return this;
    }

    public int getDimensionLength() {
        return dimensionLength;
    }

    public MinistryPlateData setDimensionLength(int dimensionLength) {
        this.dimensionLength = dimensionLength;
        return this;
    }

    public int getDimensionWidth() {
        return dimensionWidth;
    }

    public MinistryPlateData setDimensionWidth(int dimensionWidth) {
        this.dimensionWidth = dimensionWidth;
        return this;
    }

    public Axles getAxles() {
        return axles;
    }

    public MinistryPlateData setAxles(Axles axles) {
        this.axles = axles;
        return this;
    }
}
