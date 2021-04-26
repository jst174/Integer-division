package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class Division {

    private int divident;
    private int divider;
    private int quotient;
    private int partOfDivident;
    private List<Integer> digitsOfDivident;
    private List<Integer> divisionSteps;

    public Division(int divident, int divider) {
        this.divident = Math.abs(divident);
        this.divider = Math.abs(divider);
        this.quotient = divident / divider;
        validateArguments(divident, divider);
    }

    public List<Integer> prepareListOfDivisionSteps() {
        digitsOfDivident = splitNumber(divident);
        divisionSteps = new LinkedList<>();
        int beginIndex = 0;
        int endIndex = 0;
        while ((beginIndex <= endIndex) && (endIndex < digitsOfDivident.size())) {
            if (beginIndex == endIndex) {
                partOfDivident = digitsOfDivident.get(beginIndex);
            } else {
                partOfDivident = (partOfDivident * 10) + digitsOfDivident.get(endIndex);
            }
            if (partOfDivident < divider) {
                endIndex++;
            } else {
                divisionSteps.add(partOfDivident);
                divisionSteps.add(partOfDivident - (calculateRemainder()));
                if (calculateRemainder() > 0) {
                    digitsOfDivident.set(endIndex, calculateRemainder());
                } else {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
        }
        divisionSteps.set(0, divident);
        return divisionSteps;
    }

    public int calculateRemainder() {
        return partOfDivident % divider;
    }

    private List<Integer> splitNumber(int number) {
        List<Integer> digits = new LinkedList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }

    private void validateArguments(int divident, int divider) {
        if (divider == 0) {
            throw new ArithmeticException();
        }
        if (Math.abs(divident) < Math.abs(divider)) {
            throw new IllegalArgumentException();
        }
    }

    public void setDivident(int divident) {
        this.divident = divident;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public int getDivider() {
        return divider;
    }

    public int getDivident() {
        return divident;
    }

    public int getQuotient() {
        return quotient;
    }
}
