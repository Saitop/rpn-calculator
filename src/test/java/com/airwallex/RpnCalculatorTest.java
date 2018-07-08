package com.airwallex;

import org.junit.Test;
import static org.junit.Assert.*;

public class RpnCalculatorTest {

    @Test
    public void testAppHasAGreeting() {
        RpnCalculator classUnderTest = new RpnCalculator();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

}
