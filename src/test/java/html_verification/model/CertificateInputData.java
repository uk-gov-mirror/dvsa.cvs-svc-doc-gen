package html_verification.model;

public class CertificateInputData {
    private String certName;
    private String VIN;
    private String registrationNumber;
    private String Country;
    private String MakeAndModel;
    private String VehicleCategory;
    private String Mileage;
    private String DateOfTheTest;
    private String ExpiryDate;
    private String LocationOfTheTest;
    private String TestingOrgAndInspName;
    private String MotTestNumber;

    public CertificateInputData(String certName) {
        this.certName = certName;
    }

    public CertificateInputData setCertName(String certName) {
        this.certName = certName;
        return this;
    }

    public CertificateInputData setVIN(String VIN) {
        this.VIN = VIN;
        return this;
    }

    public CertificateInputData setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public CertificateInputData setCountry(String country) {
        Country = country;
        return this;
    }

    public CertificateInputData setMakeAndModel(String makeAndModel) {
        MakeAndModel = makeAndModel;
        return this;
    }

    public CertificateInputData setVehicleCategory(String vehicleCategory) {
        VehicleCategory = vehicleCategory;
        return this;
    }

    public CertificateInputData setMileage(String mileage) {
        Mileage = mileage;
        return this;
    }

    public CertificateInputData setDateOfTheTest(String dateOfTheTest) {
        DateOfTheTest = dateOfTheTest;
        return this;
    }

    public CertificateInputData setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
        return this;
    }

    public CertificateInputData setLocationOfTheTest(String locationOfTheTest) {
        LocationOfTheTest = locationOfTheTest;
        return this;
    }

    public CertificateInputData setTestingOrgAndInspName(String testingOrgAndInspName) {
        TestingOrgAndInspName = testingOrgAndInspName;
        return this;
    }

    public CertificateInputData setMotTestNumber(String motTestNumber) {
        MotTestNumber = motTestNumber;
        return this;
    }

    public String getCertName() {
        return certName;
    }

    public String getVIN() {
        return VIN;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getCountry() {
        return Country;
    }

    public String getMakeAndModel() {
        return MakeAndModel;
    }

    public String getVehicleCategory() {
        return VehicleCategory;
    }

    public String getMileage() {
        return Mileage;
    }

    public String getDateOfTheTest() {
        return DateOfTheTest;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getLocationOfTheTest() {
        return LocationOfTheTest;
    }

    public String getTestingOrgAndInspName() {
        return TestingOrgAndInspName;
    }

    public String getMotTestNumber() {
        return MotTestNumber;
    }

    @Override
    public String toString() {
        return certName;
    }
}
