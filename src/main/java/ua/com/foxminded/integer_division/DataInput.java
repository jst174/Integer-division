package ua.com.foxminded.integer_division;

import java.util.Scanner;

public class DataInput {
    private int inputDivident;
    private int inputDivider;

    public void dataInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your divident, please");
            inputDivident = scanner.nextInt();
            System.out.println("Enter your divider, please");
            inputDivider = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getInputDivident() {
        return inputDivident;
    }

    public int getInputDivider() {
        return inputDivider;
    }

}
