package com.azamorapl.katas.stringcalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static com.azamorapl.katas.stringcalculator.CustomMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by adolfo on 12/03/17.
 */
public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @Before
    public void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void canAddEmptyString(){
        assertThat(sum(""),is(0));
    }

    @Test
    public void canAddOneNumber(){
        assertThat(sum("0"),is(0));
        assertThat(sum("1"),is(1));
        assertThat(sum("2"),is(2));
        assertThat(sum("9"),is(9));
    }

    @Test
    public void canAddTwoNumbers(){
        assertThat(sum("0,0"),is(0));
        assertThat(sum("0,1"),is(1));
        assertThat(sum("3,4"),is(7));
        assertThat(sum("4,3"),is(7));
        assertThat(sum("12,108"),is(120));
    }

    @Test
    public void canAddAnyAmountOfNumbers(){
        assertThat(sum("1,2,3"),is(6));
        assertThat(sum("4,1,1,4"),is(10));
        assertThat(sum("9,1,2,5,6,3,8,7,4"),is(45));
    }

    @Test
    public void canUseLineBreakInsteadOfComma(){
        assertThat(sum("5\n10\n2"),is(17));
        assertThat(sum("1\n2,3"),is(6));
        assertThat(sum("50\n0\n33"),is(83));
    }

    @Test
    public void canUseAnyDelimiter(){
        assertThat(sum("//;\n1;2"),is(3));
        assertThat(sum("//-\n1-5-9"),is(15));
        assertThat(sum("//[moo]\n60moo9moo60moo2"),is(131));
    }

    @Test
    public void canNotAddNegatives(){
        assertThat(invalidSum("-1,100"), throwsMessage("Negatives not allowed: -1"));
        assertThat(invalidSum("3,-8"), throwsMessage("Negatives not allowed: -8"));
        assertThat(invalidSum("0,-12,5"), throwsMessage("Negatives not allowed: -12"));
        assertThat(invalidSum("-12,-91"), throwsMessage("Negatives not allowed: -12,-91"));
        assertThat(invalidSum("-9,-7,2,-7"), throwsMessage("Negatives not allowed: -9,-7,-7"));
    }

    @Test
    public void shouldIgnoreNumbersHigherThan1000(){
        assertThat(sum("4321"),is(0));
        assertThat(sum("2,1000"),is(2));
        assertThat(sum("10,2000,5,9999"),is(15));
    }

    @Test
    public void canUseMultipleDelimiters(){
        assertThat(sum("//[*][%]\n1*2%3"),is(6));
        assertThat(sum("//[foo][bar][baz]\n5foo105baz3bar7"),is(120));
        assertThat(sum("//[;][|][moo][boo]\n99moo11;10;10;8|2boo00"),is(140));
    }

    private int sum(String numbers) {
        stringCalculator.add(numbers);
        return stringCalculator.getSum();
    }

    private Exception invalidSum(String numbers){
        try{
            sum(numbers);
            return null;
        }catch(Exception e){
            return e;
        }
    }
}
