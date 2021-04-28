package ua.com.foxminded.integer_division;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormaterTest {
    private Division division;
    private DivisionFormater formater;
    private IntegersOfDivision integer;
    private DivisionResult result;

    @BeforeEach
    void setUp() {
        formater = new DivisionFormater();
        result = new DivisionResult();
        division = new Division();
        
    }

    @Test
    void resultOfInteger_DividentAndDividerIsPositive_quotientShouldBePositive() {
        integer = new IntegersOfDivision(512, 8);
        assertEquals("_512|8" + lineSeparator() + " 48 |---" + lineSeparator() + " -- |64" + lineSeparator() + 
                " _32" + lineSeparator() + "  32" + lineSeparator() + "  --" + lineSeparator() + "   0",
                formater.resultOfDivision(result, integer, division));
    }

    @Test
    void resultOfInteger_DividentIsNegative_quotientShouldBeNegative() {
        integer = new IntegersOfDivision(-512, 8);
        assertEquals("_512|8" + lineSeparator() + " 48 |---" + lineSeparator() + " -- |-64" + lineSeparator() + 
                " _32" + lineSeparator() + "  32" + lineSeparator() + "  --" + lineSeparator() + "   0",
                formater.resultOfDivision(result, integer, division));
    }

    @Test
    void resultOfInteger_DividerIsNegative_quotientShouldBeNegative() {
        integer = new IntegersOfDivision(512, -8);
        assertEquals("_512|8" + lineSeparator() + " 48 |---" + lineSeparator() + " -- |-64" + lineSeparator() + 
                " _32" + lineSeparator() + "  32" + lineSeparator() + "  --" + lineSeparator() + "   0",
                formater.resultOfDivision(result, integer, division));
    }

    @Test
    void resultOfInteger_DividerAndDividentIsNegative_quotientShouldBePositive() {
        integer = new IntegersOfDivision(-512, -8);
        assertEquals("_512|8" + lineSeparator() + " 48 |---" + lineSeparator() + " -- |64" + lineSeparator() + 
                " _32" + lineSeparator() + "  32" + lineSeparator() + "  --" + lineSeparator() + "   0",
                formater.resultOfDivision(result, integer, division));
    }

}
