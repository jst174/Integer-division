package ua.com.foxminded.division;

import java.util.LinkedList;
import java.util.List;

public class Division {

    public Result divide(int inputDivident, int inputDivider) {
        int partOfDivident = 0;
        int quotient = 0;
        int divident = Math.abs(inputDivident);
        int divider = Math.abs(inputDivider);
        int remainder = 0;
        List<Integer> digitsOfDivident = splitNumber(divident);
        List<DivisionStep> divisionSteps = new LinkedList<DivisionStep>();
        for (int endIndex = 0, beginIndex = 0; endIndex < digitsOfDivident.size();) {
            if (beginIndex == endIndex) {
                partOfDivident = digitsOfDivident.get(beginIndex);
            } else {
                partOfDivident = (partOfDivident * 10) + digitsOfDivident.get(endIndex);
            }
            if (partOfDivident < divider) {
                endIndex++;
            } else {
                remainder = partOfDivident % divider;
                quotient = (quotient * 10) + (partOfDivident / divider);
                divisionSteps.add(new DivisionStep(partOfDivident, partOfDivident - remainder));
                if (remainder > 0) {
                    digitsOfDivident.set(endIndex, remainder);
                } else {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
        }
        if ((inputDivident < 0) ^ (inputDivider < 0)) {
            quotient *= -1;
        }
        DivisionStep firstStep = divisionSteps.get(0);
        firstStep.setMinuend(divident);
        divisionSteps.set(0, firstStep);
        return new Result(divident, divider, quotient, remainder, divisionSteps);
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
