package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class Division {

    public Result performDivision(int divident, int divider) {
        int partOfDivident = 0;
        int quotient = divident / divider;
        divident = Math.abs(divident);
        divider = Math.abs(divider);
        int remainder = calculateRemainder(divident, divider);
        List<Integer> digitsOfDivident = splitNumber(divident);
        List<Integer> divisionSteps = new LinkedList<>();
        for (int endIndex = 0, beginIndex = 0; endIndex < digitsOfDivident.size();) {
            if (beginIndex == endIndex) {
                partOfDivident = digitsOfDivident.get(beginIndex);
            } else {
                partOfDivident = (partOfDivident * 10) + digitsOfDivident.get(endIndex);
            }
            if (partOfDivident < divider) {
                endIndex++;
            } else {
                divisionSteps.add(partOfDivident);
                divisionSteps.add(partOfDivident - (calculateRemainder(partOfDivident, divider)));
                if (calculateRemainder(partOfDivident, divider) > 0) {
                    digitsOfDivident.set(endIndex, calculateRemainder(partOfDivident, divider));
                } else {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
        }
        divisionSteps.set(0, divident);
        return new Result(divident, divider, quotient, remainder, divisionSteps);
    }

    public int calculateRemainder(int divident, int divider) {
        return divident % divider;
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
