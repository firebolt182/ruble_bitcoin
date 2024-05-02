package org.javaacademy.rubl_bitcoin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BitcoinRubleControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleRuntimeException() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("На сайте наблюдаются проблемы, приходите позже");
    }
}
