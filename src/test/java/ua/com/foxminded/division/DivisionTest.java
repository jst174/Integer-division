package ua.com.foxminded.division;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.division.Division;
import ua.com.foxminded.division.Result;

class DivisionTest {

    private Division division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @Test
    void division_dividerIsZero_ShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> division.divide(512, 0));
    }

    @Test
    void division_dividentAndDividerIsPositive_shouldAddToListAllSteps() {
        Result result;
        Result excpected;
        List<DivisionStep> divisionSteps = new LinkedList<>();
        int divident = 78945;
        int divider = 4;
        divisionSteps.add(new DivisionStep(78945, 4));
        divisionSteps.add(new DivisionStep(38, 36));
        divisionSteps.add(new DivisionStep(29, 28));
        divisionSteps.add(new DivisionStep(14, 12));
        divisionSteps.add(new DivisionStep(25, 24));

        result = division.divide(divident, divider);
        excpected = new Result(78945, 4, 19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void division_dividentIsNegative_shouldAddToListAllSteps() {
        Result result;
        Result excpected;
        List<DivisionStep> divisionSteps = new LinkedList<>();
        int divident = -78945;
        int divider = 4;
        divisionSteps.add(new DivisionStep(78945, 4));
        divisionSteps.add(new DivisionStep(38, 36));
        divisionSteps.add(new DivisionStep(29, 28));
        divisionSteps.add(new DivisionStep(14, 12));
        divisionSteps.add(new DivisionStep(25, 24));
        result = division.divide(divident, divider);
        excpected = new Result(78945, 4, -19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void division_dividerIsNegative_shouldAddToListAllSteps() {
        Result result;
        Result excpected;
        List<DivisionStep> divisionSteps = new LinkedList<>();
        int divident = 78945;
        int divider = -4;
        divisionSteps.add(new DivisionStep(78945, 4));
        divisionSteps.add(new DivisionStep(38, 36));
        divisionSteps.add(new DivisionStep(29, 28));
        divisionSteps.add(new DivisionStep(14, 12));
        divisionSteps.add(new DivisionStep(25, 24));
        result = division.divide(divident, divider);
        excpected = new Result(78945, 4, -19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }

    @Test
    void division_dividerAndDivisionIsNegative_shouldAddToListAllSteps() {
        Result result;
        Result excpected;
        List<DivisionStep> divisionSteps = new LinkedList<>();
        int divident = -78945;
        int divider = -4;
        divisionSteps.add(new DivisionStep(78945, 4));
        divisionSteps.add(new DivisionStep(38, 36));
        divisionSteps.add(new DivisionStep(29, 28));
        divisionSteps.add(new DivisionStep(14, 12));
        divisionSteps.add(new DivisionStep(25, 24));
        result = division.divide(divident, divider);
        excpected = new Result(78945, 4, 19736, 1, divisionSteps);
        assertEquals(excpected, result);
    }
}
