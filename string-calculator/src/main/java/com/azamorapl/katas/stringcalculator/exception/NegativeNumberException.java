package com.azamorapl.katas.stringcalculator.exception;

/**
 * Created by adolfo on 12/03/17.
 */
public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String negatives) {
        super("Negatives not allowed: " + negatives);
    }
}
