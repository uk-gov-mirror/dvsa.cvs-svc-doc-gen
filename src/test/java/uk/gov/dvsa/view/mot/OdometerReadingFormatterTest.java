package uk.gov.dvsa.view.mot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.mot.certificateData.OdometerReading;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class OdometerReadingFormatterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object []> testCases() {
        return Arrays.asList(new Object[][] {
            {
                "format in miles",
                new OdometerReading("10230", "10230", "mi", LocalDate.of(2017, 1, 12)),
                "10,230 miles",
                "10,230 milltiroedd"
            },
            {
                "format in kilometers",
                new OdometerReading("15012", "15012", "km", LocalDate.of(2017, 1, 12)),
                "15,012 km",
                "15,012 km"
            },
            {
                "format without unit",
                new OdometerReading("40,040", "40,040", null, LocalDate.of(2017, 1, 12)),
                "40,040",
                "40,040"
            },
            {
                "format remark",
                new OdometerReading("Not readable", "Dim yn ddarllenadwy", "mi", LocalDate.of(2017, 1, 12)),
                "Not readable",
                "Dim yn ddarllenadwy"
            }
        });
    }

    @Parameterized.Parameter
    public String testCase;

    @Parameterized.Parameter(1)
    public OdometerReading odometer;

    @Parameterized.Parameter(2)
    public String expectedValue;

    @Parameterized.Parameter(3)
    public String expectedWelshValue;

    private OdometerReadingFormatter formatter = new OdometerReadingFormatter();

    @Test
    public void testFormatting() {

        String result = formatter.formatValue(odometer);
        assertThat(result, equalTo(expectedValue));
    }

    @Test
    public void testWelshFormatting() {

        String result = formatter.formatWelshValue(odometer);
        assertThat(result, equalTo(expectedWelshValue));
    }
}