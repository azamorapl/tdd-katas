package com.azamorapl.katas.stringcalculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adolfo on 13/03/17.
 */
public class DelimiterParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    private String numberString;
    private List<String> delimiters = new ArrayList<>();

    public DelimiterParser() {
        delimiters.addAll(Arrays.asList(",", "\n"));
    }

    public void parse(String input) {
        numberString = extractNumberString(input);
        if (hasDelimiters(input)) {
            String ds = extractDelimiterString(input);
            findDelimiters(ds);
        }
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getNumberString() {
        return numberString;
    }

    private String extractNumberString(String input){
        if (hasDelimiters(input)) {
            int startIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
            return input.substring(startIndex);
        }else{
            return input;
        }
    }

    private boolean hasDelimiters(String input){
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String extractDelimiterString(String input){
        int startIndex = input.indexOf(CUSTOM_DELIMITER_PREFIX) + CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return input.substring(startIndex, endIndex);
    }

    private void findDelimiters(String delimiterString) {
        if (delimiterString.length() > 1) {
            findInBrackets(delimiterString);
        } else {
            delimiters.add(delimiterString);
        }
    }

    private void findInBrackets(String delimiterString) {
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(delimiterString);
        while (m.find()) delimiters.add(Pattern.quote(m.group(1)));
    }
}
