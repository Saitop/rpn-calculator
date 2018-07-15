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

    @Test
    public void shouldReturnSquareRoot() {
        Calculator calculator = new Calculator();
        calculator.process("2 sqrt");
        assertEquals("1.4142135623", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnSquareRootWithClearToken() {
        Calculator calculator = new Calculator();
        calculator.process("2 sqrt");
        assertEquals("1.4142135623", calculator.printNumberStack());

        calculator.process("clear 9 sqrt");
        assertEquals("3", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhenInputMultipleOperator() {
        Calculator calculator = new Calculator();
        calculator.process("5 2 -");
        assertEquals("3", calculator.printNumberStack());

        calculator.process("3 -");
        assertEquals("0", calculator.printNumberStack());

        calculator.process("clear");
        assertEquals("", calculator.printNumberStack());

    }

    @Test
    public void shouldAddRealNumberDecimal() {
        Calculator calculator = new Calculator();
        calculator.process("5.0123456789111 2.123332 + ");
        assertEquals("7.1356776789", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhitUndoOperator() {
        Calculator calculator = new Calculator();
        calculator.process("5 4 3 2");
        assertEquals("5 4 3 2", calculator.printNumberStack());

        calculator.process("undo undo * ");
        assertEquals("20", calculator.printNumberStack());

        calculator.process("5 * ");
        assertEquals("100", calculator.printNumberStack());

        calculator.process("undo");
        assertEquals("20 5", calculator.printNumberStack());
    }
}