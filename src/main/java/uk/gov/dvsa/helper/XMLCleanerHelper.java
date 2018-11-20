package uk.gov.dvsa.helper;

/**
 * This class is responsible for parsing strings and removing all invalid XML unicode characters;
 * specified by the XML 1.0 standard.
 *
 * http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char
 */
public class XMLCleanerHelper {

    private static final String XML_10_PATTERN = "[^"
            + "\u0009\r\n"
            + "\u0020-\uD7FF"
            + "\uE000-\uFFFD"
            + "\ud800\udc00-\udbff\udfff"
            + "]";

    private static final String EMPTY_STRING = "";

    /**
     * @param in string with non-valid characters we want to remove.
     * @return in; stripped of non-valid characters.
     */
    public static String stripInvalidXMLCharacters(String in) {
        if (in == null || in.equals(EMPTY_STRING)) {
            return EMPTY_STRING;
        }

        return in.replaceAll(XML_10_PATTERN, EMPTY_STRING);
    }
}
