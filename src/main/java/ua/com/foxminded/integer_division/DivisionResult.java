package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class DivisionResult {
    private StringBuilder string = new StringBuilder() ;
    private List<String> steps = new LinkedList<>();

    public List<Integer> resultOfDivision (Division division, IntegersOfDivision integer){
        division.division(integer);
        return integer.getDivisionSteps();
    }

    public StringBuilder getString() {
        return string;
    }

    public List<String> getSteps() {
        return steps;
    }
    
    
}
