package ua.com.foxminded.integerDivision;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerDivision.Division;
import ua.com.foxminded.integerDivision.DivisionFormater;
import ua.com.foxminded.integerDivision.Result;

class DivisionFormaterTest {

    private Division division;
    private DivisionFormater formater;
    private Result result;
    private StringBuilder expected;

    @BeforeEach
    void setUp() {
        formater = new DivisionFormater();
        division = new Division();
        expected = new StringBuilder();

    }

    @Test
    void format_argementIsNull_throwException() {
        assertThrows(IllegalArgumentException.class, () -> formater.format(null));
    }
    
    @Test
    void format_DividentAndDividerIsPositive_quotientShouldBePositive() {
        result = division.performDivision(512, 8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        assertEquals(String.valueOf(expected), formater.format(result));
    }

    @Test
    void format_DividentIsNegative_quotientShouldBeNegative() {
        result = division.performDivision(-512, 8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |-64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        assertEquals(String.valueOf(expected), formater.format(result));
    }

    @Test
    void format_DividerIsNegative_quotientShouldBeNegative() {
        result = division.performDivision(512, -8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |-64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        assertEquals(String.valueOf(expected), formater.format(result));
    }

    @Test
    void format_DividerAndDividentIsNegative_quotientShouldBePositive() {
        result = division.performDivision(-512, -8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        assertEquals(String.valueOf(expected), formater.format(result));
    }

}
