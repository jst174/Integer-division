package ua.com.foxminded.integerDivision;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerDivision.Division;
import ua.com.foxminded.integerDivision.Result;

class DivisionTest {

    private Division division;
    private Result result;
    private Result excpected;
    private int divident;
    private int divider;
    private List<Integer> divisionSteps;

    @BeforeEach
    void setUp() {
        division = new Division();
        divisionSteps = new LinkedList<>();

    }

    @Test
    void performDivision_dividerIsZero_ShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> division.performDivision(512, 0));
    }

    @Test
    void prepareListOfDivisionSteps_dividentAndDividerIsPositive_shouldAddToListAllSteps() {
        divident = 78945;
        divider = 4;
        divisionSteps.add(78945);
        divisionSteps.add(4);
        divisionSteps.add(38);
        divisionSteps.add(36);
        divisionSteps.add(29);
        divisionSteps.add(28);
        divisionSteps.add(14);
        divisionSteps.add(12);
        divisionSteps.add(25);
        divisionSteps.add(24);
        result = division.performDivision(divident, divider);
        excpected = new Result(78945, 4, 19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void prepareListOfDivisionSteps_dividentIsNegative_shouldAddToListAllSteps() {
        divident = -78945;
        divider = 4;
        divisionSteps.add(78945);
        divisionSteps.add(4);
        divisionSteps.add(38);
        divisionSteps.add(36);
        divisionSteps.add(29);
        divisionSteps.add(28);
        divisionSteps.add(14);
        divisionSteps.add(12);
        divisionSteps.add(25);
        divisionSteps.add(24);
        result = division.performDivision(divident, divider);
        excpected = new Result(78945, 4, -19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void prepareListOfDivisionSteps_dividerIsNegative_shouldAddToListAllSteps() {
        divident = 78945;
        divider = -4;
        divisionSteps.add(78945);
        divisionSteps.add(4);
        divisionSteps.add(38);
        divisionSteps.add(36);
        divisionSteps.add(29);
        divisionSteps.add(28);
        divisionSteps.add(14);
        divisionSteps.add(12);
        divisionSteps.add(25);
        divisionSteps.add(24);
        result = division.performDivision(divident, divider);
        excpected = new Result(78945, 4, -19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void prepareListOfDivisionSteps_dividerAndDivisionIsNegative_shouldAddToListAllSteps() {
        divident = -78945;
        divider = -4;
        divisionSteps.add(78945);
        divisionSteps.add(4);
        divisionSteps.add(38);
        divisionSteps.add(36);
        divisionSteps.add(29);
        divisionSteps.add(28);
        divisionSteps.add(14);
        divisionSteps.add(12);
        divisionSteps.add(25);
        divisionSteps.add(24);
        result = division.performDivision(divident, divider);
        excpected = new Result(78945, 4, 19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void calculateRemainder_dividerIsNegative_ShouldReturnRemainder() {
        assertThrows(ArithmeticException.class, () -> division.calculateRemainder(78945, 0));
    }

    @Test
    void calculateRemainder_dividerIsPositive_ShouldReturnRemainder() {
        assertEquals(1, division.calculateRemainder(78945, 4));
    }

}
