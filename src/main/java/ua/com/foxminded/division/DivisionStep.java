package ua.com.foxminded.division;

public class DivisionStep {

    private int minuend;
    private int subtrahent;

    public DivisionStep(int minuend, int subtrahent) {
        this.minuend = minuend;
        this.subtrahent = subtrahent;
    }

    public void setMinuend(int minuend) {
        this.minuend = minuend;
    }

    public void setSubtrahent(int subtrahent) {
        this.subtrahent = subtrahent;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtrahent() {
        return subtrahent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + minuend;
        result = prime * result + subtrahent;
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
        DivisionStep other = (DivisionStep) obj;
        if (minuend != other.minuend)
            return false;
        if (subtrahent != other.subtrahent)
            return false;
        return true;
    }

}
