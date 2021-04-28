package ua.com.foxminded.integer_division;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your divident, please");
            int inputDivident = scanner.nextInt();
            System.out.println("Enter your divider, please");
            int inputDivider = scanner.nextInt();
            IntegersOfDivision integers = new IntegersOfDivision(inputDivident, inputDivider);
            Division division = new Division();
            DivisionResult result = new DivisionResult();
            DivisionFormater formater = new DivisionFormater();
            System.out.println(formater.resultOfDivision(result, integers, division));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
