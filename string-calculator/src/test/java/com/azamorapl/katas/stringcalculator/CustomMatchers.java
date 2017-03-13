package com.azamorapl.katas.stringcalculator;

import com.azamorapl.katas.stringcalculator.exception.NegativeNumberException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by adolfo on 12/03/17.
 */
public class CustomMatchers {
    public static Matcher<Exception> throwsMessage(final String negatives) {
        return new BaseMatcher<Exception>() {
            @Override
            public boolean matches(final Object item) {
                final NegativeNumberException foo = (NegativeNumberException) item;
                return foo.getMessage().equals(negatives);
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("Exception should contain in message: ").appendValue(negatives);
            }
        };
    }
}
