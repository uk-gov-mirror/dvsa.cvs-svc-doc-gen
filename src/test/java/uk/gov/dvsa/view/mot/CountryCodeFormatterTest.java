package uk.gov.dvsa.view.mot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountryCodeFormatterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object []> testCases() {
        return Arrays.asList(new Object[][] {
            { "code", "GB", "GB" },
            { "lower case code", "fr", "FR" },
            { "Non EU", "XNEU", "Non EU" },
            { "Not known", "XUKN", "Not known" },
            { "Not Applicable", "XNA", "Not Applicable" },
        });
    }

    @Parameterized.Parameter
    public String testCase;

    @Parameterized.Parameter(1)
    public String code;

    @Parameterized.Parameter(2)
    public String expectedValue;

    private CountryCodeFormatter formatter = new CountryCodeFormatter();

    @Test
    public void format() {
        assertThat(formatter.format(code), equalTo(expectedValue));
    };
}