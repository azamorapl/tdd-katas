package com.azamorapl.katas.stringcalculator.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adolfo on 13/03/17.
 */
public class NumberParser {
    private List<Integer> numbers = new ArrayList<>();
    private String numberString;
    private List<String> delimiters;

    public void parse(String numberString, List<String> delimiters) {
        this.numberString = numberString;
        this.delimiters = delimiters;
        findNumbers();
    }

    private void findNumbers() {
        String regex = buildRegex();
        String[] numberArray = numberString.split(regex);
        for (String number : numberArray) {
            numbers.add(Integer.parseInt(number));
        }
    }

    private String buildRegex(){
        StringBuilder regex = new StringBuilder();
        for (String delimiter : delimiters) {
            if (regex.length() > 0) {
                regex.append("|");
            }
            regex.append(delimiter);
        }
        return regex.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
