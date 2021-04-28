package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class Division {

    public void division(IntegersOfDivision integer) {
        List<Integer> digitsOfDivident = splitNumber(integer.getDivident());
        List<Integer> divisionSteps = new LinkedList<>();
        for (int endIndex = 0, beginIndex = 0; endIndex < digitsOfDivident.size();) {
            if (beginIndex == endIndex) {
                integer.setPartOfDivident(digitsOfDivident.get(beginIndex));
            } else {
                integer.setPartOfDivident((integer.getPartOfDivident() * 10) + digitsOfDivident.get(endIndex));
            }
            if (integer.getPartOfDivident() < integer.getDivider()) {
                endIndex++;
            } else {
                divisionSteps.add(integer.getPartOfDivident());
                divisionSteps.add(integer.getPartOfDivident() - (calculateRemainder(integer)));
                if (calculateRemainder(integer) > 0) {
                    digitsOfDivident.set(endIndex, calculateRemainder(integer));
                } else {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
        }
        divisionSteps.set(0, integer.getDivident());
        integer.setDivisionSteps(divisionSteps);
    }

    public int calculateRemainder(IntegersOfDivision integer) {
        return integer.getPartOfDivident() % integer.getDivider();
    }

    private List<Integer> splitNumber(int number) {
        List<Integer> digits = new LinkedList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }

}
