package ua.com.foxminded.integer_division;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider {

    private int divident;
    private int divider;
    private int quotient;

    public List<Integer> splitNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }

    public int quantityOfDigits(int number) {
        List<Integer> digits = splitNumber(number);
        int quantity = digits.size();
        return quantity;
    }

    public int getQuotient() {
        return divident / divider;
    }

    public List<Integer> integerItem() {
        List<Integer> digitsOfDivident = splitNumber(divident);
        List<Integer> digitsOfQuotient = splitNumber(getQuotient());
        List<Integer> integerItems = new ArrayList<>();
        integerItems.add(divident);
        int incopleteDivident = digitsOfDivident.get(0);
        int i = 0;
        digitsOfDivident.remove(0);
        while (digitsOfQuotient.size() > i) {
            while (incopleteDivident < divider) {
                incopleteDivident = (incopleteDivident * 10) + digitsOfDivident.get(0);
                digitsOfDivident.remove(0);
            }
            if (i > 0) {
                integerItems.add(incopleteDivident);
            }

            int productOfNumbers = digitsOfQuotient.get(i) * divider;
            integerItems.add(productOfNumbers);
            incopleteDivident = incopleteDivident - productOfNumbers;
            i++;
            if (digitsOfQuotient.size() == i) {
                integerItems.add(incopleteDivident);
            }
        }
        return integerItems;
    }

    public void setDivident(int divident) {
        this.divident = divident;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    
}
