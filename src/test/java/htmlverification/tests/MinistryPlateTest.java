package htmlverification.tests;

import com.github.jknack.handlebars.Handlebars;
import htmlverification.framework.page_object.CertificatePageObject;
import htmlverification.service.CertificateTestDataProvider;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvsa.model.cvs.MinistryPlate;
import uk.gov.dvsa.service.HtmlGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class MinistryPlateTest {

    protected HtmlGenerator htmlGenerator;
    protected MinistryPlate testCertificate;
    protected CertificatePageObject certificatePageObject;

    public MinistryPlateTest() {
        this.htmlGenerator = new HtmlGenerator(new Handlebars());
    }

    @Before
    public void setup() throws IOException {
        testCertificate = CertificateTestDataProvider.getMinistryPlate();
        String certHtml = htmlGenerator.generate(testCertificate).get(0);
        certificatePageObject = new CertificatePageObject(certHtml);
    }

    @Test
    public void verifyVin() {
        String chassisNumber = certificatePageObject.getVin();
        assertEquals(testCertificate.getPlateData().getVin(), chassisNumber);
    }

    @Test
    public void verifyDtpNumber() {
        String dtpNumber = certificatePageObject.getDtpNumber();
        assertEquals(testCertificate.getPlateData().getDtpNumber(), dtpNumber);
    }

    @Test
    public void verifyPrimaryVrm() {
        String primaryVrm = certificatePageObject.getPrimaryVrm();
        assertEquals(testCertificate.getPlateData().getPrimaryVrm(), primaryVrm);
    }

    @Test
    public void verifyPlateSerialNumber() {
        String plateSerialNumber = certificatePageObject.getPlateSerialNumber();
        assertEquals(testCertificate.getPlateData().getPlateSerialNumber(), plateSerialNumber);
    }

    @Test
    public void verifyVariantNumber() {
        String variantNumber = certificatePageObject.getVariantNumber();
        assertEquals(testCertificate.getPlateData().getVariantNumber(), variantNumber);
    }

    @Test
    public void verifyApprovalTypeNumber() {
        String approvalTypeNumber = certificatePageObject.getApprovalTypeNumber();
        assertEquals(testCertificate.getPlateData().getApprovalTypeNumber(), approvalTypeNumber);
    }

    @Test
    public void verifyMakeAndModel() {
        String makeAndModel = certificatePageObject.getMakeAndModel();
        String make = testCertificate.getPlateData().getMake();
        String model = testCertificate.getPlateData().getModel();
        assertEquals(make + "/" + model, makeAndModel);
    }

    @Test
    public void verifySpeedLimiterMrk() {
        String speedLimiterMrk = certificatePageObject.getSpeedLimiterMrk();
        assertEquals(testCertificate.getPlateData().getSpeedLimiterMrk(), speedLimiterMrk);
    }

    @Test
    public void verifyFunctionCode() {
        String functionCode = certificatePageObject.getFunctionCode();
        assertEquals(testCertificate.getPlateData().getFunctionCode(), functionCode);
    }

    @Test
    public void verifyRegnDate() {
        String regnDate = certificatePageObject.getRegnDate();
        assertEquals(testCertificate.getPlateData().getRegnDate(), regnDate);
    }

    @Test
    public void verifyManufactureYear() {
        String manufactureYear = certificatePageObject.getManufactureYear();
        assertEquals(testCertificate.getPlateData().getManufactureYear(), manufactureYear);
    }

    @Test
    public void verifyGrossGbWeight() {
        String grossGbWeight = certificatePageObject.getGrossGbWeight();
        assertEquals(testCertificate.getPlateData().getGrossGbWeight(), grossGbWeight);
    }

    @Test
    public void verifyGrossEecWeight() {
        String grossEecWeight = certificatePageObject.getGrossEecWeight();
        assertEquals(testCertificate.getPlateData().getGrossEecWeight(), grossEecWeight);
    }

    @Test
    public void verifyGrossDesignWeight() {
        String grossDesignWeight = certificatePageObject.getGrossDesignWeight();
        assertEquals(testCertificate.getPlateData().getGrossDesignWeight(), grossDesignWeight);
    }

    @Test
    public void verifyTrainGbWeight() {
        String trainGbWeight = certificatePageObject.getTrainGbWeight();
        assertEquals(testCertificate.getPlateData().getTrainGbWeight(), trainGbWeight);
    }

    @Test
    public void verifyTrainEecWeight() {
        String trainEecWeight = certificatePageObject.getTrainEecWeight();
        assertEquals(testCertificate.getPlateData().getTrainEecWeight(), trainEecWeight);
    }

    @Test
    public void verifyTrainDesignWeight() {
        String trainDesignWeight = certificatePageObject.getTrainDesignWeight();
        assertEquals(testCertificate.getPlateData().getTrainDesignWeight(), trainDesignWeight);
    }

    @Test
    public void verifyMaxTrainGbWeight() {
        String maxTrainGbWeight = certificatePageObject.getMaxTrainGbWeight();
        assertEquals(testCertificate.getPlateData().getMaxTrainGbWeight(), maxTrainGbWeight);
    }

    @Test
    public void verifyMaxTrainEecWeight() {
        String maxTrainEecWeight = certificatePageObject.getMaxTrainEecWeight();
        assertEquals(testCertificate.getPlateData().getMaxTrainEecWeight(), maxTrainEecWeight);
    }

    @Test
    public void verifyMaxLoadOnCoupling() {
        String maxLoadOnCoupling = certificatePageObject.getMaxLoadOnCoupling();
        assertEquals(testCertificate.getPlateData().getMaxLoadOnCoupling(), maxLoadOnCoupling);
    }

    @Test
    public void verifyDimensionLength() {
        String dimensionLength = certificatePageObject.getDimensionLength();
        assertEquals(testCertificate.getPlateData().getDimensionLength(), dimensionLength);
    }

    @Test
    public void verifyDimensionWidth() {
        String dimensionWidth = certificatePageObject.getDimensionWidth();
        assertEquals(testCertificate.getPlateData().getDimensionWidth(), dimensionWidth);
    }

    @Test
    public void verifyFrontAxleTo5thWheelCouplingMin() {
        String frontAxleTo5thWheelCouplingMin = certificatePageObject.getFrontAxleTo5thWheelCouplingMin();
        assertEquals(testCertificate.getPlateData().getFrontAxleTo5thWheelCouplingMin(), frontAxleTo5thWheelCouplingMin);
    }

    @Test
    public void verifyFrontAxleTo5thWheelCouplingMax() {
        String frontAxleTo5thWheelCouplingMax = certificatePageObject.getFrontAxleTo5thWheelCouplingMax();
        assertEquals(testCertificate.getPlateData().getFrontAxleTo5thWheelCouplingMax(), frontAxleTo5thWheelCouplingMax);
    }

    @Test
    public void verifyCouplingCenterToRearTrlMax() {
        String couplingCenterToRearTrlMax = certificatePageObject.getCouplingCenterToRearTrlMax();
        assertEquals(testCertificate.getPlateData().getCouplingCenterToRearTrlMax(), couplingCenterToRearTrlMax);
    }

    @Test
    public void verifyCouplingCenterToRearTrlMin() {
        String couplingCenterToRearTrlMin = certificatePageObject.getCouplingCenterToRearTrlMin();
        assertEquals(testCertificate.getPlateData().getCouplingCenterToRearTrlMin(), couplingCenterToRearTrlMin);
    }

    @Test
    public void verifyPlateIssueDate() {
        String plateIssueDate = certificatePageObject.getPlateIssueDate();
        assertEquals(testCertificate.getPlateData().getPlateIssueDate(), plateIssueDate);
    }

    @Test
    public void verifyTyreUseCode() {
        String tyreUseCode = certificatePageObject.getTyreUseCode();
        assertEquals(testCertificate.getPlateData().getTyreUseCode(), tyreUseCode);
    }
}
