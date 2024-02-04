package com.example.calculator;

import com.example.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.calculator.CalculatorServiceImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplParameterTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @MethodSource("provideArgumentForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfSum(int num1, int num2) {
        assertEquals(num1 + num2, out.add(num1, num2));
    }

    @MethodSource("provideArgumentForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfMinus(int num1, int num2) {
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @MethodSource("provideArgumentForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfMultiply(int num1, int num2) {
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

    @MethodSource("provideArgumentForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfDivide(int num1, int num2) {
        assertEquals(num1 / num2, out.divide(num1, num2));
    }

    private static Stream<Arguments> provideArgumentForCalculatorTests() {
        return Stream.of(
                Arguments.of(ZERO, ONE),
                Arguments.of(ZERO, TWO),
                Arguments.of(ONE, ONE),
                Arguments.of(ONE, TWO),
                Arguments.of(TWO, TWO)
        );
    }
}
