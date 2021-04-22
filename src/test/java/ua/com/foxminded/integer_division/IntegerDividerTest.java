package ua.com.foxminded.integer_division;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerDividerTest {

    private IntegerDivider divider;

    @BeforeEach
    void setUp() throws Exception {
        divider = new IntegerDivider();
    }

    @Test
    void splitDivident_shouldSplitDivider() {
        List<Integer> excpected = new ArrayList<>();
        excpected.add(4);
        excpected.add(5);
        excpected.add(6);
        assertEquals(excpected, divider.splitNumber(456));
    }

    @Test
    void integerItem_shouldAddToListAllItem() {
        divider.setDivident(78945);
        divider.setDivider(4);
        List<Integer> excpected = new ArrayList<>();
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
        excpected.add(1);

        assertEquals(excpected, divider.integerItem());
    }

    @Test
    void quantityOfDigits_shouldReturnQuantityOfDigitsInNumber() {
        assertEquals(5, divider.quantityOfDigits(19736));
    }

    @Test
    void getQuotient_shouldReturnResultOfDivision() {
        divider.setDivident(23);
        divider.setDivider(7);
        assertEquals(3, divider.getQuotient());
    }
}
