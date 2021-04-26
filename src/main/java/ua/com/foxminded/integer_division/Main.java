package ua.com.foxminded.integer_division;

public class Main {

    public static void main(String[] args) {
        DataInput input = new DataInput();
        input.dataInput();
        Division divider = new Division(input.getInputDivident(), input.getInputDivider());
        ResultViewer viewer = new ResultViewer();
        viewer.printResult(divider);
    }

}
