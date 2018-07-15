package com.airwallex;

import com.airwallex.exception.CalculatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnNumberStack() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("5 2");
        assertEquals("5 2", calculator.printNumberStack());
    }

    @Test
    public void shouldProcess10DecimalPlacesAndReturnNumberStack() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("5.0123456789111 2.123332");
        assertEquals("5.0123456789 2.123332", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnSquareRoot() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("2 sqrt");
        assertEquals("1.4142135623", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnSquareRootWithClearToken() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("2 sqrt");
        assertEquals("1.4142135623", calculator.printNumberStack());

        calculator.process("clear 9 sqrt");
        assertEquals("3", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhenInputMultipleOperator() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("5 2 -");
        assertEquals("3", calculator.printNumberStack());

        calculator.process("3 -");
        assertEquals("0", calculator.printNumberStack());

        calculator.process("clear");
        assertEquals("", calculator.printNumberStack());

    }

    @Test
    public void shouldAddRealNumberDecimal() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("5.0123456789111 2.123332 + ");
        assertEquals("7.1356776789", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhitUndoOperator() throws CalculatorException {
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

    @Test
    public void shouldReturnCorrectValueWhitDivisionOperation() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("7 12 2 /");
        assertEquals("7 6", calculator.printNumberStack());

        calculator.process("*");
        assertEquals("42", calculator.printNumberStack());

        calculator.process("4 /");
        assertEquals("10.5", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhitNegativeResult() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("1 2 3 4 5");
        assertEquals("1 2 3 4 5", calculator.printNumberStack());

        calculator.process("*");
        assertEquals("1 2 3 20", calculator.printNumberStack());

        calculator.process("clear 3 4 -");
        assertEquals("-1", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhitContinuousOperation() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("1 2 3 4 5");
        assertEquals("1 2 3 4 5", calculator.printNumberStack());

        calculator.process("* * * * ");
        assertEquals("120", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnWarningWhenParametersInsufficient() throws CalculatorException {
        expectedException.expect(CalculatorException.class);
        expectedException.expectMessage("operator * (position: 15): insufficient parameters");
        Calculator calculator = new Calculator();
        calculator.process("1 2 3 * 5 + * * 6 5");
        assertEquals("11", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnWarningWhenParametersInsufficientWithDivision() throws CalculatorException {
        expectedException.expect(CalculatorException.class);
        expectedException.expectMessage("operator / (position: 3): insufficient parameters");
        Calculator calculator = new Calculator();
        calculator.process("1 /");
        assertEquals("1", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnWarningWhenDividedByZero() throws CalculatorException {
        expectedException.expect(CalculatorException.class);
        expectedException.expectMessage("Cannot divide by 0.");
        Calculator calculator = new Calculator();
        calculator.process("8 9 2 0 /");
    }

    @Test
    public void shouldReturnCorrectNumberWhenNumberWithSign() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("8 -9 +2 0 ");
        assertEquals("8 -9 2 0", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnCorrectValueWhenCalculateNumberWithSign() throws CalculatorException {
        Calculator calculator = new Calculator();
        calculator.process("8 -9 +2 0 + + + ");
        assertEquals("1", calculator.printNumberStack());
    }

    @Test
    public void shouldReturnWarningWhenUndoAndEmptyStack() throws CalculatorException {
        expectedException.expect(CalculatorException.class);
        expectedException.expectMessage("Stack is empty, please do not perform 'undo'");
        Calculator calculator = new Calculator();
        calculator.process("undo");
    }

    @Test
    public void shouldReturnSqrtWarningWithCorrectOperationInputPositionWhenSqrtEmptyStack() throws CalculatorException {
        expectedException.expect(CalculatorException.class);
        expectedException.expectMessage("operator sqrt (position: 1): insufficient parameters");
        Calculator calculator = new Calculator();
        calculator.process("sqrt");
    }
}