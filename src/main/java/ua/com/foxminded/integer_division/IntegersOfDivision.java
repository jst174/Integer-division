package ua.com.foxminded.integer_division;

import java.util.List;

public class IntegersOfDivision {

    private int divident;
    private int divider;
    private int quotient;
    private int partOfDivident;
    private int lengthDivident;
    private int lenghtSubstractedNumber;
    private List<Integer> divisionSteps;

    public IntegersOfDivision(int divident, int divider) {
        this.divident = Math.abs(divident);
        this.divider = Math.abs(divider);
        this.quotient = divident / divider;
        validateArguments(divident, divider);
    }

    private void validateArguments(int divident, int divider) {
        if (divider == 0) {
            throw new ArithmeticException();
        }
    }

    public int getDivident() {
        return divident;
    }

    public int getDivider() {
        return divider;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getPartOfDivident() {
        return partOfDivident;
    }

    public void setPartOfDivident(int partOfDivident) {
        this.partOfDivident = partOfDivident;
    }

    public int getLengthDivident() {
        return lengthDivident;
    }

    public void setLengthDivident(int lengthDivident) {
        this.lengthDivident = lengthDivident;
    }

    public int getLenghtSubstractedNumber() {
        return lenghtSubstractedNumber;
    }

    public void setLenghtSubstractedNumber(int lenghtSubstractedNumber) {
        this.lenghtSubstractedNumber = lenghtSubstractedNumber;
    }

    public List<Integer> getDivisionSteps() {
        return divisionSteps;
    }

    public void setDivisionSteps(List<Integer> divisionSteps) {
        this.divisionSteps = divisionSteps;
    }
    
    

}
