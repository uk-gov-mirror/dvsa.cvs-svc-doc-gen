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

public enum DocumentsConfig {
    EU_CT_20(CertificateTemplates.EU_CT20.getCertificateName(), CT20.class,
            new String[]{CertificateTemplates.EU_CT20.getCertificateName()}),
    EU_CT_30(CertificateTemplates.EU_CT30.getCertificateName(), CT30.class,
            new String[]{CertificateTemplates.EU_CT30.getCertificateName()}),

    CT_20(CertificateTemplates.CT20.getCertificateName(), CT20.class,
            new String[]{CertificateTemplates.CT20.getCertificateName()}),
    CT_30(CertificateTemplates.CT30.getCertificateName(), CT30.class,
            new String[]{CertificateTemplates.CT30.getCertificateName()}),
    CT_32(CertificateTemplates.CT32.getCertificateName(), CT32.class,
            new String[]{CertificateTemplates.CT32.getCertificateName()}),

    VT_30(CertificateTemplates.VT30.getCertificateName(), VT30.class,
            new String[]{CertificateTemplates.VT30.getCertificateName()}),
    VT_20(CertificateTemplates.VT20.getCertificateName(),VT20.class,
            new String[]{CertificateTemplates.VT20.getCertificateName()}),
    VT_20W(CertificateTemplates.VT20W.getCertificateName(), VT20W.class,
            new String[]{CertificateTemplates.VT20.getCertificateName(), CertificateTemplates.VT20W.getCertificateName()}),
    VT_30W(CertificateTemplates.VT30W.getCertificateName(), VT30W.class,
        new String[]{CertificateTemplates.VT30.getCertificateName(), CertificateTemplates.VT30W.getCertificateName()});

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
