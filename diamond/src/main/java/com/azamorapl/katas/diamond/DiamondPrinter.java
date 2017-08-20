package com.azamorapl.katas.diamond;

import java.util.Arrays;

public class DiamondPrinter {
    private static final char[] ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private StringBuilder output;
    private int lastIndex;
    private int currentIndex;

    public String print(char lastChar) {
        this.output = new StringBuilder();
        this.lastIndex = new String(ALPHABET).indexOf(lastChar);
        appendDiamond();
        return output.toString();
    }

    private void appendDiamond(){
        appendTop();
        appendBottom();
    }

    private void appendTop(){
        for (currentIndex = 0; currentIndex < lastIndex; currentIndex++){
            appendRow();
            appendNewLine();
        }
    }

    private void appendBottom(){
        for (currentIndex = lastIndex; currentIndex >=0; currentIndex--){
            appendRow();
            if (isNotTipOfDiamond()) appendNewLine();
        }
    }

    private void appendRow(){
        appendOuterSpaces();
        appendMiddle();
        appendOuterSpaces();
    }

    private void appendMiddle(){
        appendChar(currentIndex);
        if (isNotTipOfDiamond()) {
            appendMiddleSpaces();
            appendChar(currentIndex);
        }
    }

    private void appendNewLine(){
        output.append('\n');
    }

    private void appendOuterSpaces(){
        appendSpaces(lastIndex - currentIndex);
    }

    private void appendMiddleSpaces(){
        appendSpaces(currentIndex + (currentIndex - 1));
    }

    private void appendSpaces(int quantity){
        char[] blanks = new char[quantity];
        Arrays.fill(blanks, ' ');
        output.append(blanks);
    }

    private void appendChar(int charIndex) {
        output.append(ALPHABET[charIndex]);
    }

    private boolean isNotTipOfDiamond(){
        return currentIndex != 0;
    }
}