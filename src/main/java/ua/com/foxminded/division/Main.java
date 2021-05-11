package ua.com.foxminded.division;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your divident, please");
            int inputDividend = scanner.nextInt();
            System.out.println("Enter your divider, please");
            int inputDivider = scanner.nextInt();
            Division division = new Division();
            Result result = division.divide(inputDividend, inputDivider);
            DivisionFormater formater = new DivisionFormater();
            System.out.println(formater.format(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
