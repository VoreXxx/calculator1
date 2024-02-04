package com.example.calculator.service;

import com.example.calculator.exception.ZeroDivideException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public Integer minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public Integer divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new ZeroDivideException();
        }
        return num1 / num2;
    }
}
