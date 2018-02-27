package uk.gov.dvsa.view.mot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.mot.certificateData.OdometerReading;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MotTestNumberFormatterTest {


    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object []> testCases() {
        return Arrays.asList(new Object[][] {
            { "number", "180681400628", "1806 8140 0628", "1806 8140 0628" },
            { "not recorded value", null, "Not recorded", "Heb gofnodi" },
            { "not recorded value", "", "Not recorded", "Heb gofnodi" },
        });
    }

    private final MotTestNumberFormatter formatter = new MotTestNumberFormatter();

    @Parameterized.Parameter
    public String testCase;

    @Parameterized.Parameter(1)
    public String input;

    @Parameterized.Parameter(2)
    public String expectedValue;

    @Parameterized.Parameter(3)
    public String expectedWelshValue;


    @Test
    public void format() {

        String result = formatter.format(input);

        assertEquals(expectedValue, result);
    }

    @Test
    public void formatWelsh() {

        String result = formatter.formatWelsh(input);

        assertEquals(expectedWelshValue, result);
    }
}