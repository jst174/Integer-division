package ua.com.foxminded.division;

import java.util.ArrayList;
import java.util.List;

public class Division {

    public Result divide(int inputDividend, int inputDivider) {
        int partOfDividend = 0;
        int quotient = 0;
        int dividend = Math.abs(inputDividend);
        int divider = Math.abs(inputDivider);
        int remainder = 0;
        List<Integer> digitsOfDividend = splitNumber(dividend);
        List<DivisionStep> divisionSteps = new ArrayList<>();
        int i = 0;
        for (int digit : digitsOfDividend) {
            i++;
            partOfDividend = partOfDividend * 10 + digit;
            if (partOfDividend >= divider) {
                int partOfQuotient = partOfDividend / divider;
                int subtrahent = partOfQuotient * divider;
                quotient = (quotient * 10) + partOfQuotient;
                divisionSteps.add(new DivisionStep(partOfDividend, subtrahent));
                remainder = partOfDividend - subtrahent;
                partOfDividend = remainder;
            } else {
                if (i == digitsOfDividend.size()) {
                    remainder = digit;
                    quotient *= 10;
                }
            }
        }
        if ((inputDividend < 0) ^ (inputDivider < 0)) {
            quotient *= -1;
        }
        DivisionStep firstStep = divisionSteps.get(0);
        firstStep.setMinuend(dividend);
        divisionSteps.set(0, firstStep);
        return new Result(dividend, divider, quotient, remainder, divisionSteps);
    }

    private List<Integer> splitNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }

}
