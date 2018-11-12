package uk.gov.dvsa.helper;

import org.junit.Test;
import static org.junit.Assert.*;

public class XMLCleanerHelperTest {

    @Test
    public void checkIfInvalidCharactersAreRemovedFromString() {
        String stringWithInvalidXMLCharacter =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "  <to>\u0008Tove</to>\n" +
                "  <from>Jani\f</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        String expectedString =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        String result = XMLCleanerHelper.stripInvalidXMLCharacters(stringWithInvalidXMLCharacter);

        assertEquals(expectedString, result);
    }
}
