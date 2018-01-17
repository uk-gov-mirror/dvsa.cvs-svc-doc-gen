package html_verification.service;

import html_verification.model.CertificateInputData;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class HtmlGenerator {

    public String generate(CertificateInputData certificateInputData) {
        String html = getDummyHtml(); // TODO: Use proper service from Lambda's code

        return html;
    }

    private String getDummyHtml() {
        URL htmlURL = HtmlGenerator.class.getResource("/dummy_generated_html/VT20.html");

        try {
            File indexContent = new File(htmlURL.toURI());
            return FileUtils.readFileToString(indexContent, "UTF-8");
        } catch (Exception e) {

        }

        return null;
    }
}
