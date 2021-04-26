package ua.com.foxminded.integer_division;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormaterTest {
    private Division division;
    private DivisionFormater formater;

    @BeforeEach
    void setUp() {
        formater = new DivisionFormater();
    }

    @Test
    void resultOfInteger_DividentAndDividerIsPositive_quotientShouldBePositive() {
        division = new Division(512, 8);
        assertEquals("_512|8\n" + " 48 |---\n" + " -- |64\n" + " _32\n" + "  32\n" + "  --\n" + "   0",
                formater.resultOfDivision(division));
    }

    @Test
    void resultOfInteger_DividentIsNegative_quotientShouldBeNegative() {
        division = new Division(-512, 8);
        assertEquals("_512|8\n" + " 48 |---\n" + " -- |-64\n" + " _32\n" + "  32\n" + "  --\n" + "   0",
                formater.resultOfDivision(division));
    }

    @Test
    void resultOfInteger_DividerIsNegative_quotientShouldBeNegative() {
        division = new Division(512, -8);
        assertEquals("_512|8\n" + " 48 |---\n" + " -- |-64\n" + " _32\n" + "  32\n" + "  --\n" + "   0",
                formater.resultOfDivision(division));
    }

    @Test
    void resultOfInteger_DividerAndDividentIsNegative_quotientShouldBePositive() {
        division = new Division(512, -8);
        assertEquals("_512|8\n" + " 48 |---\n" + " -- |-64\n" + " _32\n" + "  32\n" + "  --\n" + "   0",
                formater.resultOfDivision(division));
    }

}
