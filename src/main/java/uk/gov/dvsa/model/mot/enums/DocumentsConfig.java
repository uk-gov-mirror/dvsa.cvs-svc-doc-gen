package uk.gov.dvsa.model.mot.enums;

import uk.gov.dvsa.exception.HttpException;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.CT20;
import uk.gov.dvsa.model.mot.CT30;
import uk.gov.dvsa.model.mot.CT32;
import uk.gov.dvsa.model.mot.VT20;
import uk.gov.dvsa.model.mot.VT20W;
import uk.gov.dvsa.model.mot.VT30;
import uk.gov.dvsa.model.mot.VT30W;
import uk.gov.dvsa.model.mot.VT32VE;
import uk.gov.dvsa.model.mot.PRS;
import uk.gov.dvsa.model.mot.PRSW;

public enum DocumentsConfig {
    EU_CT_20(CertificateTypes.EU_CONTINGENCY_PASS.getType(), CT20.class,
            new String[]{CertificateTemplates.EU_CT20.getCertificateTemplateName()}),
    EU_CT_30(CertificateTypes.EU_CONTINGENCY_FAIL.getType(), CT30.class,
            new String[]{CertificateTemplates.EU_CT30.getCertificateTemplateName()}),

    CT_20(CertificateTypes.CONTINGENCY_PASS.getType(), CT20.class,
            new String[]{CertificateTemplates.CT20.getCertificateTemplateName()}),
    CT_30(CertificateTypes.CONTINGENCY_FAIL.getType(), CT30.class,
            new String[]{CertificateTemplates.CT30.getCertificateTemplateName()}),
    CT_32(CertificateTypes.CONTINGENCY_ADVISORY_NOTICE.getType(), CT32.class,
            new String[]{CertificateTemplates.CT32.getCertificateTemplateName()}),

    VT_30(CertificateTypes.FAIL.getType(), VT30.class,
            new String[]{CertificateTemplates.VT30.getCertificateTemplateName()}),
    VT_20(CertificateTypes.PASS.getType(),VT20.class,
            new String[]{CertificateTemplates.VT20.getCertificateTemplateName()}),
    VT_20W(CertificateTypes.WELSH_PASS.getType(), VT20W.class,
            new String[]{CertificateTemplates.VT20.getCertificateTemplateName(), CertificateTemplates.VT20W.getCertificateTemplateName()}),
    VT_30W(CertificateTypes.WELSH_FAIL.getType(), VT30W.class,
            new String[]{CertificateTemplates.VT30.getCertificateTemplateName(), CertificateTemplates.VT30W.getCertificateTemplateName()}),
    PRS(CertificateTypes.PRS.getType(), PRS.class,
            new String[]{CertificateTemplates.VT20.getCertificateTemplateName(), CertificateTemplates.VT30.getCertificateTemplateName()}),
    PRSW(CertificateTypes.WELSH_PRS.getType(), PRSW.class,
            new String[]{CertificateTemplates.VT20.getCertificateTemplateName(), CertificateTemplates.VT30.getCertificateTemplateName(),
            CertificateTemplates.VT20W.getCertificateTemplateName(), CertificateTemplates.VT30W.getCertificateTemplateName()}),
    VT_32VE(CertificateTypes.ADVISORY_NOTICE.getType(), VT32VE.class,
            new String[]{CertificateTemplates.VT32VE.getCertificateTemplateName()}),
    VT_32VEW(CertificateTypes.WELSH_ADVISORY_NOTICE.getType(), VT32VE.class,
            new String[]{CertificateTemplates.VT32VEW.getCertificateTemplateName()}),
    EU_VT_32VE(CertificateTypes.COMPLIANCE_ADVISORY_NOTICE.getType(), VT32VE.class,
            new String[]{CertificateTemplates.VT32VE.getCertificateTemplateName()}),
    EU_VT_32VEW(CertificateTypes.COMPLIANCE_WELSH_ADVISORY_NOTICE.getType(), VT32VE.class,
            new String[]{CertificateTemplates.VT32VEW.getCertificateTemplateName()});

    private final String documentName;
    private final Class<? extends Document> baseClass;
    private final String[] templateNames; // names and order of handlebars templates used to generate a PDF

    DocumentsConfig(String documentName, Class<? extends Document> baseClass, String[] templateNames) {
        this.documentName = documentName;
        this.baseClass = baseClass;
        this.templateNames = templateNames;
    }

    public Class<? extends Document> getBaseClass() {
        return baseClass;
    }

    public static DocumentsConfig fromDocumentName(String name) {
        for (DocumentsConfig document: DocumentsConfig.values()) {
            if (document.getDocumentName().equals(name)) {
                return document;
            }
        }
        throw new HttpException.NotFoundException("Unknown document name: " + name);
    }

    public String getDocumentName() {
        return documentName;
    }

    public String[] getTemplateNames() {
        return templateNames;
    }
}
