package uk.gov.dvsa.service;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import uk.gov.dvsa.exception.HtmlTemplateException;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.enums.DocumentsConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlGenerator {

    private Handlebars handlebars;

    public HtmlGenerator(Handlebars handlebars) {
        this.handlebars = registerNewlineHelper(handlebars);
    }

    public List<String> generate(Document context) throws IOException {
        List<String> htmlDocuments = new ArrayList<>();
        String[] templateNames = DocumentsConfig.fromDocumentName(context.getDocumentName()).getTemplateNames();

        for (String templateName: templateNames) {
            Template template = getTemplate(templateName);
            htmlDocuments.add(template.apply(context));
        }

        return htmlDocuments;
    }

    private Template getTemplate(String templateName) {
        try {
            return handlebars.compile(String.format("views/%s", templateName));
        } catch (IOException e) {
            throw new HtmlTemplateException(e);
        }
    }

    private Handlebars registerNewlineHelper(Handlebars handlebars) {
        return handlebars.registerHelper("newline", (context, options) ->
                context.toString().replace("\n", "<br/>")
        );
    }
}
