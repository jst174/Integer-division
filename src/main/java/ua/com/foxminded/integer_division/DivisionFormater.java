package ua.com.foxminded.integer_division;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DivisionFormater {

    private static final String SPACE = " ";
    private static final String MINUS = "_";
    private static final String HYPHENS = "-";
    private static final String SLAH = "|";
    private StringBuilder string;
    private int lengthDivident;
    private int lenghtSubstractedNumber;
    private List<String> steps;

    public String resultOfDivision(Division resultOfDivision) {
        prepareStepsForPrint(resultOfDivision);
        return String.valueOf(string);
    }

    private void prepareStepsForPrint(Division resultOfDivision) {
        string = new StringBuilder();
        formatStepsToString(resultOfDivision);
        lengthDivident = steps.get(0).length();
        lenghtSubstractedNumber = steps.get(1).length();
        addFirstRow(resultOfDivision);
        addSecondRow();
        addThirdRow(resultOfDivision);
        addOtherRows();
        addEndRow(resultOfDivision);
    }

    private void formatStepsToString(Division resultOfDivision) {
        List<Integer> divisionSteps = resultOfDivision.prepareListOfDivisionSteps();
        steps = new ArrayList<>();
        for (int step : divisionSteps) {
            steps.add(String.valueOf(step));
        }
    }

    private void addFirstRow(Division resultOfDivision) {
        string.append(MINUS + steps.get(0) + SLAH + String.valueOf(resultOfDivision.getDivider()) + "\n");
    }

    private void addSecondRow() {
        string.append(SPACE + steps.get(1) + quantityOfSpaces(lengthDivident - lenghtSubstractedNumber) + SLAH
                + quantityOfHyphens(lengthDivident) + "\n");
    }

    private void addThirdRow(Division resultOfDivision) {
        string.append(SPACE + quantityOfHyphens(lenghtSubstractedNumber)
                + quantityOfSpaces(lengthDivident - lenghtSubstractedNumber) + SLAH
                + String.valueOf(resultOfDivision.getQuotient()) + "\n");
    }

    private void addOtherRows() {
        String secondRow = SPACE + steps.get(1);
        int lengthIndents = secondRow.length();
        for (int i = 2; i < steps.size() - 1;) {
            int lengthMinuend = steps.get(i).length();
            int lengthSubtrahent = steps.get(i + 1).length();
            String minuendRow = quantityOfSpaces(lengthIndents - lengthMinuend) + MINUS + steps.get(i) + "\n";
            lengthIndents = minuendRow.length() - 1;
            String subtrahentRow = quantityOfSpaces(lengthIndents - lengthSubtrahent) + steps.get(i + 1) + "\n";
            lengthIndents = subtrahentRow.length() - 1;
            String dividingRow = quantityOfSpaces(lengthIndents - lengthSubtrahent)
                    + quantityOfHyphens(lengthSubtrahent) + "\n";
            string.append(minuendRow);
            string.append(subtrahentRow);
            string.append(dividingRow);
            i += 2;
        }
    }

    private void addEndRow(Division resultOfDivision) {
        int remainder = resultOfDivision.calculateRemainder();
        int lengthRemainder = String.valueOf(remainder).length() - 1;
        String endRow = quantityOfSpaces(lengthDivident - lengthRemainder) + (remainder);
        string.append(endRow);
    }

    private String quantityOfSpaces(int length) {
        String spaces = "";
        for (int i = 0; i < length; i++) {
            spaces = spaces.concat(SPACE);
        }
        return spaces;
    }

    private String quantityOfHyphens(int length) {
        String hyphens = "";
        for (int i = 0; i < length; i++) {
            hyphens = hyphens.concat(HYPHENS);
        }
        return hyphens;
    }

}
