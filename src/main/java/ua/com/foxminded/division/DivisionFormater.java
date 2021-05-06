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
        StringBuilder string = new StringBuilder();
        List<String> steps = new LinkedList<>();
        prepareStepsForPrint(result, string, steps);
        return String.valueOf(string);
    }

    private void prepareStepsForPrint(Result result, StringBuilder string, List<String> steps) {
        formatStepsToString(result, steps);
        int lengthDivident = steps.get(0).length();
        int lenghtSubstarctedNumber = steps.get(1).length();
        buildHeader(string, steps, result, lengthDivident, lenghtSubstarctedNumber);
        buildSteps(string, steps);
        buildRemainder(string, result, lengthDivident);
    }

    private void formatStepsToString(Result result, List<String> steps) {
        for (DivisionStep step : result.getDivisionSteps()) {
            steps.add(String.valueOf(step.getMinuend()));
            steps.add(String.valueOf(step.getSubtrahent()));
        }
    }

    private void buildHeader(StringBuilder string, List<String> steps, Result result, int lengthDivident,
            int lengthSubstarctedNumber) {
        addFirstRow(string, steps, result);
        addSecondRow(string, steps, lengthDivident, lengthSubstarctedNumber);
        addThirdRow(string, result, lengthDivident, lengthSubstarctedNumber);
    }

    private void buildSteps(StringBuilder string, List<String> steps) {
        String secondRow = SPACE + steps.get(1);
        int lengthIndents = secondRow.length();
        for (int i = 2; i < steps.size() - 1;) {
            int lengthMinuend = steps.get(i).length();
            int lengthSubtrahent = steps.get(i + 1).length();
            String minuendRow = addSymbol(lengthIndents - lengthMinuend, SPACE) + MINUS + steps.get(i)
                    + lineSeparator();
            lengthIndents = minuendRow.length() - 2;
            String subtrahentRow = addSymbol(lengthIndents - lengthSubtrahent, SPACE) + steps.get(i + 1)
                    + lineSeparator();
            lengthIndents = subtrahentRow.length() - 2;
            String dividingRow = addSymbol(lengthIndents - lengthSubtrahent, SPACE)
                    + addSymbol(lengthSubtrahent, HYPHENS) + lineSeparator();
            string.append(minuendRow);
            string.append(subtrahentRow);
            string.append(dividingRow);
            i += 2;
        }
    }

    private void buildRemainder(StringBuilder string, Result result, int lengthDivident) {
        int lengthRemainder = String.valueOf(result.getRemainder()).length() - 1;
        String endRow = addSymbol(lengthDivident - lengthRemainder, SPACE) + (result.getRemainder());
        string.append(endRow);
    }

    private void addFirstRow(StringBuilder string, List<String> steps, Result result) {
        string.append(MINUS + steps.get(0) + SLAH + String.valueOf(result.getDivider()) + lineSeparator());
    }

    private void addSecondRow(StringBuilder string, List<String> steps, int lenghtDivident,
            int lenghtSubstarctedNumber) {
        string.append(SPACE + steps.get(1) + addSymbol(lenghtDivident - lenghtSubstarctedNumber, SPACE) + SLAH
                + addSymbol(lenghtDivident, HYPHENS) + lineSeparator());
    }

    private void addThirdRow(StringBuilder string, Result result, int lenghtDivident, int lenghtSubstarctedNumber) {
        string.append(SPACE + addSymbol(lenghtSubstarctedNumber, HYPHENS)
                + addSymbol(lenghtDivident - lenghtSubstarctedNumber, SPACE) + SLAH
                + String.valueOf((result.getQuotient()) + lineSeparator()));
    }

    private String addSymbol(int length, char symbol) {
        String separator = "";
        for (int i = 0; i < length; i++) {
            separator = separator + symbol;
        }
        return separator;
    }

}
