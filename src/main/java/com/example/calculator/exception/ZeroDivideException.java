package com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZeroDivideException extends IllegalArgumentException {
    public ZeroDivideException() {
        super("Ошибка деление на ноль");
    }
}
