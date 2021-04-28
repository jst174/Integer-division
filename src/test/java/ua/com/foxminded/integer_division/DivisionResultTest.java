package ua.com.foxminded.integer_division;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionResultTest {

    private DivisionResult result;
    private IntegersOfDivision integer;
    private Division division;
    
    @BeforeEach
    void setUp() {
        result = new DivisionResult();
        division = new Division();
    }

    @Test
    void prepareListOfDivisionSteps_dividentAndDividerIsPositive_shouldAddToListAllSteps() {
        integer = new IntegersOfDivision(78945, 4);
        List<Integer> excpected = new LinkedList<>();
        excpected.add(78945);
        excpected.add(4);
        excpected.add(38);
        excpected.add(36);
        excpected.add(29);
        excpected.add(28);
        excpected.add(14);
        excpected.add(12);
        excpected.add(25);
        excpected.add(24);
        assertEquals(excpected, result.resultOfDivision(division, integer));
    }

    @Test
    void prepareListOfDivisionSteps_dividentIsNegative_shouldAddToListAllSteps() {
        integer = new IntegersOfDivision(-78945, 4);
        List<Integer> excpected = new LinkedList<>();
        excpected.add(78945);
        excpected.add(4);
        excpected.add(38);
        excpected.add(36);
        excpected.add(29);
        excpected.add(28);
        excpected.add(14);
        excpected.add(12);
        excpected.add(25);
        excpected.add(24);
        assertEquals(excpected, result.resultOfDivision(division, integer));
    }

    @Test
    void prepareListOfDivisionSteps_dividerIsNegative_shouldAddToListAllSteps() {
        integer = new IntegersOfDivision(78945, -4);
        List<Integer> excpected = new LinkedList<>();
        excpected.add(78945);
        excpected.add(4);
        excpected.add(38);
        excpected.add(36);
        excpected.add(29);
        excpected.add(28);
        excpected.add(14);
        excpected.add(12);
        excpected.add(25);
        excpected.add(24);
        assertEquals(excpected, result.resultOfDivision(division, integer));
    }

    @Test
    void prepareListOfDivisionSteps_dividerAndDivisionIsNegative_shouldAddToListAllSteps() {
        integer = new IntegersOfDivision(-78945, 4);
        List<Integer> excpected = new LinkedList<>();
        excpected.add(78945);
        excpected.add(4);
        excpected.add(38);
        excpected.add(36);
        excpected.add(29);
        excpected.add(28);
        excpected.add(14);
        excpected.add(12);
        excpected.add(25);
        excpected.add(24);
        assertEquals(excpected, result.resultOfDivision(division, integer));
    }

    @Test
    void dividerIsZero_ShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> new IntegersOfDivision(512, 0));
    }

}
