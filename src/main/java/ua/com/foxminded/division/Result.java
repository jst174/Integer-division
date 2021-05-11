package ua.com.foxminded.division;

import java.util.LinkedList;
import java.util.List;

public class Result {

    private final int dividend;
    private final int divider;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> divisionSteps;

    public Result(final int divident, final int divider, final int quotient, final int remainder,
            final List<DivisionStep> divisionSteps) {
        this.dividend = divident;
        this.divider = divider;
        this.quotient = quotient;
        this.remainder = remainder;
        this.divisionSteps = divisionSteps;
    }

    public int getDividend() {
        return dividend;
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

    public List<DivisionStep> getDivisionSteps() {
        return divisionSteps;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dividend;
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
        if (dividend != other.dividend)
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
