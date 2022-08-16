package com.pichincha.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidationException(MethodArgumentNotValidException exception) {
        ArrayList<String> messages = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(e ->{
            messages.add(e.getDefaultMessage());
        });
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }
}
