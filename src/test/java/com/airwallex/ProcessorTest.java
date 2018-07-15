package com.airwallex;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProcessorTest {

    @Test
    public void shouldReturnTrueWhenEvaluateRealNumber() {
        Processor processor = new Processor();
        assertTrue(processor.isNumber("42"));
        assertTrue(processor.isNumber("13.323234234"));
        assertTrue(processor.isNumber("+42"));
        assertTrue(processor.isNumber("-42"));
        assertTrue(processor.isNumber("-0"));
        assertTrue(processor.isNumber("+0"));
        assertTrue(processor.isNumber("0"));
    }

    @Test
    public void shouldReturnFalseWhenWhenEvaluateNotRealNumber() {
        Processor processor = new Processor();
        assertFalse(processor.isNumber("hanxian"));
        assertFalse(processor.isNumber("   "));
        assertFalse(processor.isNumber(" \ndd "));
    }

    @Test
    public void shouldReturnTrueWhenEvaluateValidOperation() {
        Processor processor = new Processor();
        assertTrue(processor.isValidOperator("sqrt"));
        assertTrue(processor.isValidOperator("+"));
        assertTrue(processor.isValidOperator("-"));
        assertTrue(processor.isValidOperator("*"));
        assertTrue(processor.isValidOperator("/"));
        assertTrue(processor.isValidOperator("undo"));
        assertTrue(processor.isValidOperator("clear"));
    }

    @Test
    public void shouldReturnFalseWhenEvaluateInvalidOperation() {
        Processor processor = new Processor();
        assertFalse(processor.isValidOperator("33"));
        assertFalse(processor.isValidOperator("dd"));
        assertFalse(processor.isValidOperator("  "));
        assertFalse(processor.isValidOperator("  \n s"));
        assertFalse(processor.isValidOperator("&  \n s"));
        assertFalse(processor.isValidOperator("@"));
    }

    @Test
    public void shouldReturnTrueWhenEvaluateSpaceAndEnter() {
        Processor processor = new Processor();
        assertTrue(processor.isSpaceOrEnter("\n"));
        assertTrue(processor.isSpaceOrEnter("  "));
        assertTrue(processor.isSpaceOrEnter("  \n"));
    }
}