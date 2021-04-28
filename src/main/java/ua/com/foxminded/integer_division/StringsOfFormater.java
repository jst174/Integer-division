package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class StringsOfFormater {

    private StringBuilder string = new StringBuilder();
    private List<String> steps = new LinkedList<>();
    
    public StringBuilder getString() {
        return string;
    }
    public void setString(StringBuilder string) {
        this.string = string;
    }
    public List<String> getSteps() {
        return steps;
    }
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
    
    
}
