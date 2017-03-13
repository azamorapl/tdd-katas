package com.azamorapl.katas.stringcalculator;

import com.azamorapl.katas.stringcalculator.exception.NegativeNumberException;
import com.azamorapl.katas.stringcalculator.parser.DelimiterParser;
import com.azamorapl.katas.stringcalculator.parser.NumberParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adolfo on 12/03/17.
 */
public class StringCalculator {
    private int sum;
    private List<String> negatives;

    public void add(String inputString) {
        sum = 0;
        negatives = new ArrayList<>();
        if (!inputString.isEmpty()) parse(inputString);
    }

    public int getSum() {
        return sum;
    }

    private void parse(String inputString){
        DelimiterParser dp = new DelimiterParser();
        dp.parse(inputString);
        NumberParser np = new NumberParser();
        np.parse(dp.getNumberString(), dp.getDelimiters());
        addNumbers(np.getNumbers());
        checkForNegatives();
    }

    private void addNumbers(List<Integer> numbers){
        for (int number : numbers){
            addIfValid(number);
        }
    }

    private void addIfValid(int number){
        if (number < 0) negatives.add(String.valueOf(number));
        if (number < 1000) sum += number;
    }


    private void checkForNegatives() {
        if (!negatives.isEmpty()) {
            String n = String.join(",", negatives);
            throw new NegativeNumberException(n);
        }
    }

}
