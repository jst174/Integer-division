package ua.com.foxminded.integer_division;

import static java.lang.System.lineSeparator;
import java.util.LinkedList;
import java.util.List;

public class DivisionFormater {

    private static final String SPACE = " ";
    private static final String MINUS = "_";
    private static final String HYPHENS = "-";
    private static final String SLAH = "|";

    public String resultOfDivision(DivisionResult resultOfDivision, IntegersOfDivision integer, Division division) {
        prepareStepsForPrint(resultOfDivision, integer, division);
        return String.valueOf(resultOfDivision.getString());
    }

    private void prepareStepsForPrint(DivisionResult resultOfDivision, IntegersOfDivision integer, Division division) {

        formatStepsToString(resultOfDivision, integer, division);
        integer.setLengthDivident(resultOfDivision.getSteps().get(0).length());
        integer.setLenghtSubstractedNumber(resultOfDivision.getSteps().get(1).length());
        addFirstRow(resultOfDivision,integer);
        addSecondRow(resultOfDivision,integer);
        addThirdRow(resultOfDivision,integer);
        addOtherRows(resultOfDivision);
        addEndRow(resultOfDivision, integer, division);
        String.valueOf(resultOfDivision.getString());
    }

    private void formatStepsToString(DivisionResult resultOfDivision, IntegersOfDivision integer, Division division) {
        for (int step : resultOfDivision.resultOfDivision(division, integer)) {
            resultOfDivision.getSteps().add(String.valueOf(step));
        }
    }

    private void addFirstRow(DivisionResult result, IntegersOfDivision integer) {
        result.getString().append(MINUS + result.getSteps().get(0) + SLAH + String.valueOf(integer.getDivider()) + lineSeparator());
    }

    private void addSecondRow(DivisionResult result, IntegersOfDivision integer) {
        result.getString().append(SPACE + result.getSteps().get(1)
                + quantityOfSpaces(integer.getLengthDivident() - integer.getLenghtSubstractedNumber()) + SLAH
                + quantityOfHyphens(integer.getLengthDivident()) + lineSeparator());
    }

    private void addThirdRow(DivisionResult result, IntegersOfDivision integer) {
        result.getString().append(SPACE + quantityOfHyphens(integer.getLenghtSubstractedNumber())
                + quantityOfSpaces(integer.getLengthDivident() - integer.getLenghtSubstractedNumber()) + SLAH
                + String.valueOf(integer.getQuotient()) + lineSeparator());
    }

    private void addOtherRows(DivisionResult result) {
        String secondRow = SPACE + result.getSteps().get(1);
        int lengthIndents = secondRow.length();
        for (int i = 2; i < result.getSteps().size() - 1;) {
            int lengthMinuend = result.getSteps().get(i).length();
            int lengthSubtrahent = result.getSteps().get(i + 1).length();
            String minuendRow = quantityOfSpaces(lengthIndents - lengthMinuend) + MINUS + result.getSteps().get(i)
                    + lineSeparator();
            lengthIndents = minuendRow.length() - 2;
            String subtrahentRow = quantityOfSpaces(lengthIndents - lengthSubtrahent) + result.getSteps().get(i + 1)
                    + lineSeparator();
            lengthIndents = subtrahentRow.length() - 2;
            String dividingRow = quantityOfSpaces(lengthIndents - lengthSubtrahent)
                    + quantityOfHyphens(lengthSubtrahent) + lineSeparator();
            result.getString().append(minuendRow);
            result.getString().append(subtrahentRow);
            result.getString().append(dividingRow);
            i += 2;
        }
    }

    private void addEndRow(DivisionResult resultOfDivision, IntegersOfDivision integer, Division division) {
        int remainder = division.calculateRemainder(integer);
        int lengthRemainder = String.valueOf(remainder).length() - 1;
        String endRow = quantityOfSpaces(integer.getLengthDivident() - lengthRemainder) + (remainder);
        resultOfDivision.getString().append(endRow);
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
