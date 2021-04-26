package ua.com.foxminded.integer_division;

public class ResultViewer {

    DivisionFormater formater;

    public void printResult(Division resultOfDivision) {
        formater = new DivisionFormater();    
        System.out.println(formater.resultOfDivision(resultOfDivision));
    }

}
