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
        System.out.println(regex);
        String[] numberArray = numberString.split(regex);
        System.out.println(numberString);
        for (String number : numberArray) {
            System.out.println(number);
            numbers.add(Integer.parseInt(number));
        }
    }

    private String buildRegex(){
        String regex = "";
        for (String delimiter : delimiters) {
            if (!regex.isEmpty()) {
                regex += "|";
            }
            regex += delimiter;
        }
        return regex;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
