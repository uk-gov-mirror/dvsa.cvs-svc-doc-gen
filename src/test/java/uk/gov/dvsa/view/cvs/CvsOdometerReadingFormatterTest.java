package uk.gov.dvsa.view.cvs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.gov.dvsa.model.cvs.certificateData.CvsOdometerReading;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class CvsOdometerReadingFormatterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object []> testCases() {
        return Arrays.asList(new Object[][] {
                {
                        "format in miles",
                        new CvsOdometerReading("10230", "mi", "01.12.2017"),
                        "10,230 miles"
                },
                {
                        "format in kilometers",
                        new CvsOdometerReading("15012", "km", "01.12.2017"),
                        "15,012 kilometres"
                },
                {
                        "format without unit",
                        new CvsOdometerReading("40,040", null, "01.12.2017"),
                        "40,040"
                },
                {
                        "format remark",
                        new CvsOdometerReading("Not readable", "mi", "01.12.2017"),
                        "Not readable"
                }
        });
    }

    @Parameterized.Parameter
    public String testCase;

    @Parameterized.Parameter(1)
    public CvsOdometerReading odometer;

    @Parameterized.Parameter(2)
    public String expectedValue;

    private CvsOdometerReadingFormatter formatter = new CvsOdometerReadingFormatter();

    @Test
    public void testFormatting() {

        String result = formatter.formatValue(odometer);
        assertThat(result, equalTo(expectedValue));
    }
}