package uk.gov.dvsa.service;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import uk.gov.dvsa.exception.HtmlTemplateException;
import uk.gov.dvsa.model.Document;

import java.io.IOException;

public class HtmlGenerator {

    private Handlebars handlebars;

    public HtmlGenerator(Handlebars handlebars) {
        this.handlebars = handlebars;
    }

    public String generate(String documentName, Document context) throws IOException {
        Template template = getTemplate(documentName);
        return template.apply(context);
    }

    private Template getTemplate(String templateName) throws HtmlTemplateException {
        try {
            return handlebars.compile(String.format("views/MOT/%s", templateName));
        } catch (IOException e) {
            throw new HtmlTemplateException(e);
        }
    }
}
