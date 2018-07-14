package com.airwallex;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void shouldReturnNumberStack() {
        Calculator calculator = new Calculator();
        calculator.process("5 2");
        assertEquals("5 2", calculator.printNumberStack());
    }

    @Test
    public void shouldProcess10DecimalPlacesAndReturnNumberStack() {
        Calculator calculator = new Calculator();
        calculator.process("5.0123456789111 2.123332");
        assertEquals("5.0123456789 2.123332", calculator.printNumberStack());
    }
}