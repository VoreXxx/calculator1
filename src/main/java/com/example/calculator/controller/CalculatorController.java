package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping(path = "/plus")
    public String addNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.add(num1, num2);
        return createResponse(num1, num2, '+', result);
    }

    @GetMapping(path = "/minus")
    public String minusNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.minus(num1, num2);
        return createResponse(num1, num2, '-', result);
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.multiply(num1, num2);
        return createResponse(num1, num2, '*', result);
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            return "<h1>Второе число равно 0. Деление на 0 невозможно</h1>";
        }
        Integer result = calculatorService.divide(num1, num2);
        return createResponse(num1, num2, '/', result);
    }

    private String createResponse(Integer num1, Integer num2, char operator, Integer result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, operator, num2, result);
    }
}
