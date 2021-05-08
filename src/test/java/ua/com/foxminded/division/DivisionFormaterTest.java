package ua.com.foxminded.division;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.division.Division;
import ua.com.foxminded.division.DivisionFormater;
import ua.com.foxminded.division.Result;

class DivisionFormaterTest {

    private DivisionFormater formater;

    @BeforeEach
    void setUp() {
        formater = new DivisionFormater();
    }

    @Test
    void format_argementIsNull_throwException() {
        assertThrows(IllegalArgumentException.class, () -> formater.format(null));
    }

    @Test
    void format_DividentAndDividerIsPositive_quotientShouldBePositive() {
        Division division = new Division();
        StringBuilder expected = new StringBuilder();
        Result result = division.divide(512, 8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        
        assertEquals(expected.toString(), formater.format(result));
        
    }

    @Test
    void format_DividentIsNegative_quotientShouldBeNegative() {
        Division division = new Division();
        StringBuilder expected = new StringBuilder();
        Result result = division.divide(-512, 8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |-64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        
        assertEquals(expected.toString(), formater.format(result));
        
    }

    @Test
    void format_DividerIsNegative_quotientShouldBeNegative() {
        Division division = new Division();
        StringBuilder expected = new StringBuilder();
        Result result = division.divide(512, -8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |-64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        
        assertEquals(expected.toString(), formater.format(result));
        
    }

    @Test
    void format_DividerAndDividentIsNegative_quotientShouldBePositive() {
        Division division = new Division();
        StringBuilder expected = new StringBuilder();
        Result result = division.divide(-512, -8);
        expected.append("_512|8" + lineSeparator());
        expected.append(" 48 |---" + lineSeparator());
        expected.append(" -- |64" + lineSeparator());
        expected.append(" _32" + lineSeparator());
        expected.append("  32" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   0");
        
        assertEquals(expected.toString(), formater.format(result));
        
    }

}
