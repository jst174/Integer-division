package ua.com.foxminded.integer_division;

import java.util.LinkedList;
import java.util.List;

public class Result {
    private final int divident;
    private final int divider;
    private final int quotient;
    private final int remainder;
    private final List<Integer> divisionSteps;

    public Result(final int divident, final int divider, final int quotient, final int remainder,
            final List<Integer> divisionSteps) {
        this.divident = divident;
        this.divider = divider;
        this.quotient = quotient;
        this.remainder = remainder;
        this.divisionSteps = divisionSteps;
    }

    public int getDivident() {
        return divident;
    }

    public int getDivider() {
        return divider;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public List<Integer> getDivisionSteps() {
        return divisionSteps;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + divident;
        result = prime * result + divider;
        result = prime * result + ((divisionSteps == null) ? 0 : divisionSteps.hashCode());
        result = prime * result + quotient;
        result = prime * result + remainder;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Result other = (Result) obj;
        if (divident != other.divident)
            return false;
        if (divider != other.divider)
            return false;
        if (divisionSteps == null) {
            if (other.divisionSteps != null)
                return false;
        } else if (!divisionSteps.equals(other.divisionSteps))
            return false;
        if (quotient != other.quotient)
            return false;
        if (remainder != other.remainder)
            return false;
        return true;
    }

}
