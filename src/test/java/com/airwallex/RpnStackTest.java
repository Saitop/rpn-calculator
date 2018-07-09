package com.airwallex;

import org.junit.Test;

import static org.junit.Assert.*;

public class RpnStackTest {

    @Test
    public void shouldReturnNumberStack() {
        RpnStack rpnStack = new RpnStack();
        rpnStack.process("5 2");
        assertEquals("5 2", rpnStack.printNumberStack());
    }

    @Test
    public void shouldProcess10DecimalPlacesAndReturnNumberStack() {
        RpnStack rpnStack = new RpnStack();
        rpnStack.process("5.0123456789111 2.123332");
        assertEquals("5.0123456789 2.123332", rpnStack.printNumberStack());
    }
}