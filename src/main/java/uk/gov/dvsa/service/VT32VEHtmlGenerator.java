package uk.gov.dvsa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.jknack.handlebars.Handlebars;

import uk.gov.dvsa.logging.LogContextWrapper;
import uk.gov.dvsa.model.Document;
import uk.gov.dvsa.model.mot.VT32VE;
import uk.gov.dvsa.model.mot.enums.Vt32defectsConfig;

public class VT32VEHtmlGenerator extends HtmlGenerator {
    public static final String FOOTER = "This is the result of a Quality Control check carried out by a DVSA Examiner";
    public static final String FOOTER_WELSH = "Mae hyn yn ganlyniad i archwiliad Rheoli Ansawdd a gynhaliwyd gan Arholwr DVSA";

    private static final String BREAK_LINE = "<br/>";
    private static final String SPACE = " ";
    private static final int MAX_LETTERS_IN_LINE = 100;
    private static final int MAX_DEFECT_BOX_LINES_COUNT = 40;

    private boolean isDangerousHeaderNeeded = false;
    private List<String> pageElements = new ArrayList<>();
    private List<List<String>> pagesContent = new ArrayList<>();
    private Map<Vt32defectsConfig, List<String>> documentMapConfig;
    private VT32VE document;

    public VT32VEHtmlGenerator(Handlebars handlebars) {
        super(handlebars);
    }

    @Override
    public List<String> generate(Document documentToGenerate) {
        if (documentToGenerate instanceof VT32VE) {
            document = (VT32VE) documentToGenerate;
        } else {
            throw new RuntimeException();
        }
        initializeDocumentConfig();

        handleRFRs();
        addFooterAndHandleElementsOverflow();

        return generateHtmls();
    }

    private void addFooterAndHandleElementsOverflow() {
        addFooter();
        addPageElementsToList(pageElements);
        handleElementsOverflow();
    }

    private void initializeDocumentConfig() {
        List<String> dangerousDefects = document.getFailData().getEuDangerousDefects();
        List<String> majorDefects = document.getFailData().getEuMajorDefects();
        List<String> minorDefects = document.getFailData().getEuMinorDefects();
        List<String> advisoryDefects = document.getFailData().getEuAdvisoryDefects();

        document.setPostEu(isPostEu());
        document.setWelsh(isWelsh());

        if (dangerousDefects != null && document.isWelsh()) {
            isDangerousHeaderNeeded = true;
        }

        HashMap<Vt32defectsConfig, List<String>> temporaryMap = new LinkedHashMap<>();
        temporaryMap.put(Vt32defectsConfig.DANGEROUS_DEFECTS, dangerousDefects);
        temporaryMap.put(Vt32defectsConfig.MAJOR_DEFECTS, majorDefects);
        temporaryMap.put(Vt32defectsConfig.MINOR_DEFECTS, minorDefects);
        temporaryMap.put(Vt32defectsConfig.ADVISORY_DEFECTS, advisoryDefects);
        temporaryMap.put(Vt32defectsConfig.DANGEROUS_DEFECTS_WELSH, dangerousDefects);
        temporaryMap.put(Vt32defectsConfig.MAJOR_DEFECTS_WELSH, majorDefects);
        temporaryMap.put(Vt32defectsConfig.MINOR_DEFECTS_WELSH, minorDefects);
        temporaryMap.put(Vt32defectsConfig.ADVISORY_DEFECTS_WELSH, advisoryDefects);
        temporaryMap.put(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS, majorDefects);
        temporaryMap.put(Vt32defectsConfig.PRE_EU_ADVISORIES, advisoryDefects);
        temporaryMap.put(Vt32defectsConfig.PRE_EU_FAIL_DEFECTS_WELSH, majorDefects);
        temporaryMap.put(Vt32defectsConfig.PRE_EU_ADVISORIES_WELSH, advisoryDefects);

        documentMapConfig = Collections.unmodifiableMap(new LinkedHashMap<>(temporaryMap));
    }

    private List<String> generateHtmls() {
        return IntStream.range(0, pagesContent.size())
            .mapToObj(i -> generateHtmlFromDocument(pagesContent.get(i), i))
            .collect(Collectors.toList());
    }

    private String generateHtmlFromDocument(List<String> documentElements, int index) {
        int currentPageNumber = index + 1;
        document.setDefectElements(documentElements);
        document.setCurrentPageNumber(currentPageNumber);
        document.setMaxPageNumber(pagesContent.size());

        try {
            LogContextWrapper.setPageNumber(String.valueOf(currentPageNumber));
            return super.generate(document).get(0);
        } finally {
            LogContextWrapper.cleanupPageNumber();
        }
    }

    private void handleRFRs() {
        if (isDangerousHeaderNeeded) {
            addDangerousHeader();
        }
        handleRfrsPaging();
    }

    private void handleRfrsPaging() {
        documentMapConfig.entrySet()
            .stream()
            .filter(entry -> entry.getValue() != null)
            .filter(entry ->  entry.getKey().isWelsh() == document.isWelsh())
            .filter(entry -> entry.getKey().isPostEu() == document.isPostEu())
            .forEach(entry -> addRFRsToPage(entry.getValue(), entry.getKey().getHeaderText()));
    }

    private void addDangerousHeader() {
        pageElements.add(createHeaderElement(Vt32defectsConfig.DANGEROUS_DEFECTS.getHeaderText()));
    }

    private void addRFRsToPage(List<String> defects, String header) {
        if (!defects.isEmpty()) {
            String textHeader = createHeaderElement(header);
            pageElements.add(textHeader);
            defects.stream().forEach(defect -> handleSingleDefect(defect));
            pageElements.add(BREAK_LINE);
        }
    }

    private void handleSingleDefect(String defect) {
        if (defect.isEmpty()) {
            pageElements.add(BREAK_LINE);
        } else {
            splitStringIntoLines(defect);
        }

        if (pageElements.size() >= MAX_DEFECT_BOX_LINES_COUNT) {
            addPageElementsToList(new ArrayList<>(pageElements.subList(0, MAX_DEFECT_BOX_LINES_COUNT)));
            pageElements = pageElements.subList(MAX_DEFECT_BOX_LINES_COUNT, pageElements.size());
        }
    }

    private void handleElementsOverflow() {
        if (pageElements.size() > MAX_DEFECT_BOX_LINES_COUNT) {
            addPageElementsToList(pageElements.subList(MAX_DEFECT_BOX_LINES_COUNT, pageElements.size()));
        }
    }

    private void addPageElementsToList(List<String> pageElements) {
        pagesContent.add(pageElements);
    }

    private void splitStringIntoLines(String string) {
        List<String> words = Arrays.asList(string.split(SPACE));

        int lettersCounter = 0;
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            lettersCounter += word.length() + 1;
            if (sb.length() < 1) {
                sb.append(word);
            } else if (lettersCounter < MAX_LETTERS_IN_LINE) {
                sb.append(" ").append(word);
            } else {
                pageElements.add(Handlebars.Utils.escapeExpression(sb).toString());
                sb = new StringBuilder(word);
                lettersCounter = word.length();
            }
        }
        pageElements.add(Handlebars.Utils.escapeExpression(sb).toString());
    }

    private boolean isWelsh() {
        return document.getDocumentName().endsWith("W");
    }

    private boolean isPostEu() {
        return document.getDocumentName().contains("EU_");
    }

    private String createHeaderElement(String headerText) {
        return String.format("<span class='boxes__item-text__heading'>%s</span>", headerText);
    }

    private void addFooter() {
        pageElements.add(FOOTER);
        if (document.isWelsh()) {
            pageElements.add(FOOTER_WELSH);
        }
    }
}
