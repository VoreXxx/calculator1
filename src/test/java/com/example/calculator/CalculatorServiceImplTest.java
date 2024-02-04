package com.example.calculator;

import com.example.calculator.exception.ZeroDivideException;
import com.example.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import static com.example.calculator.CalculatorServiceImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturn3WhenSum1And2() {
        assertEquals(THREE, out.add(ONE, TWO));
    }

    @Test
    public void shouldReturn2WhenSum0And2() {
        assertEquals(TWO, out.add(ZERO, TWO));
    }

    @Test
    public void shouldReturn0WhenMinus2And2() {
        assertEquals(ZERO, out.minus(TWO, TWO));
    }

    @Test
    public void shouldReturn1WhenMinus2And1() {
        assertEquals(ONE, out.minus(TWO, ONE));
    }

    @Test
    public void shouldReturn1WhenMultiply1And1() {
        assertEquals(ONE, out.multiply(ONE, ONE));
    }

    @Test
    public void shouldReturn2WhenMultiply2And1() {
        assertEquals(TWO, out.multiply(TWO, ONE));
    }

    @Test
    public void shouldReturn1WhenDivide1And1() {
        assertEquals(ONE, out.multiply(ONE, ONE));
    }
    @Test
    public void shouldReturn2WhenDivide2And1() {
        assertEquals(TWO, out.multiply(TWO, ONE));
    }

    @Test
    public void shouldThrowZeroDividerExceptionWhenDivideAnyNumAnd0() {
        assertThrows(ZeroDivideException.class, () -> out.divide(TWO, ZERO));
    }
}
