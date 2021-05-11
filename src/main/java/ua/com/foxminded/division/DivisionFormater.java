package ua.com.foxminded.division;

import static java.lang.System.lineSeparator;
import java.util.LinkedList;
import java.util.List;

public class DivisionFormater {

    private static final char SPACE = ' ';
    private static final char MINUS = '_';
    private static final char HYPHENS = '-';
    private static final char SLAH = '|';

    public String format(Result result) {
        if (result == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder divisionResult = new StringBuilder();
        List<DivisionStep> steps = result.getDivisionSteps();
        prepareStepsForPrint(result, divisionResult, steps);
        return divisionResult.toString();
    }

    private void prepareStepsForPrint(Result result, StringBuilder divisionResult, List<DivisionStep> steps) {
        int lengthDividend = String.valueOf(result.getDividend()).length();
        int lenghtSubstarctedNumber = String.valueOf(steps.get(0).getSubtrahent()).length();
        buildHeader(divisionResult, steps, result, lengthDividend, lenghtSubstarctedNumber);
        buildSteps(divisionResult, steps);
        buildRemainder(divisionResult, result, lengthDividend);
    }

    private void buildHeader(StringBuilder divisionResult, List<DivisionStep> steps, Result result, int lengthDividend,
            int lengthSubstarctedNumber) {
        addFirstRow(divisionResult, steps, result);
        addSecondRow(divisionResult, steps, lengthDividend, lengthSubstarctedNumber);
        addThirdRow(divisionResult, result, lengthDividend, lengthSubstarctedNumber);
    }

    private void buildSteps(StringBuilder divisionResult, List<DivisionStep> steps) {
        String secondRow = SPACE + String.valueOf(steps.get(0).getSubtrahent());
        int lengthIndents = secondRow.length();
        for (int i = 1; i < steps.size(); i++) {
            int lengthMinuend = String.valueOf(steps.get(i).getMinuend()).length();
            int lengthSubtrahent = String.valueOf(steps.get(i).getSubtrahent()).length();
            String minuendRow = addSymbol(lengthIndents - lengthMinuend, SPACE) + MINUS
                    + String.valueOf(steps.get(i).getMinuend()) + lineSeparator();
            lengthIndents = minuendRow.length() - 2;
            String subtrahentRow = addSymbol(lengthIndents - lengthSubtrahent, SPACE)
                    + String.valueOf(steps.get(i).getSubtrahent()) + lineSeparator();
            lengthIndents = subtrahentRow.length() - 2;
            String dividingRow = addSymbol(lengthIndents - lengthSubtrahent, SPACE)
                    + addSymbol(lengthSubtrahent, HYPHENS) + lineSeparator();
            divisionResult.append(minuendRow);
            divisionResult.append(subtrahentRow);
            divisionResult.append(dividingRow);
        }
    }

    private void buildRemainder(StringBuilder divisionResult, Result result, int lengthDividend) {
        int lengthRemainder = String.valueOf(result.getRemainder()).length() - 1;
        String endRow = addSymbol(lengthDividend - lengthRemainder, SPACE) + (result.getRemainder());
        divisionResult.append(endRow);
    }

    private void addFirstRow(StringBuilder divisionResult, List<DivisionStep> steps, Result result) {
        divisionResult.append(MINUS + String.valueOf(result.getDividend()) + SLAH + String.valueOf(result.getDivider())
                + lineSeparator());
    }

    private void addSecondRow(StringBuilder divisionResult, List<DivisionStep> steps, int lenghtDividend,
            int lenghtSubstarctedNumber) {
        divisionResult.append(SPACE + String.valueOf(steps.get(0).getSubtrahent())
                + addSymbol(lenghtDividend - lenghtSubstarctedNumber, SPACE) + SLAH + addSymbol(lenghtDividend, HYPHENS)
                + lineSeparator());
    }

    private void addThirdRow(StringBuilder divisionResult, Result result, int lenghtDividend,
            int lenghtSubstarctedNumber) {
        divisionResult.append(SPACE + addSymbol(lenghtSubstarctedNumber, HYPHENS)
                + addSymbol(lenghtDividend - lenghtSubstarctedNumber, SPACE) + SLAH
                + String.valueOf((result.getQuotient()) + lineSeparator()));
    }

    private String addSymbol(int length, char symbol) {
        String separator = "";
        for (int i = 0; i < length; i++) {
            separator += symbol;
        }
        return separator;
    }

}
