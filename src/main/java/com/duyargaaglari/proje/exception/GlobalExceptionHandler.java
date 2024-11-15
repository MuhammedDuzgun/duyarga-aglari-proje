package com.duyargaaglari.proje.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<String> requestNotPermittedHandler(RequestNotPermitted requestNotPermitted) {
        return new ResponseEntity<>("1 Dakikada en fazla 1 istek atabilirsiniz.", HttpStatus.TOO_MANY_REQUESTS);
    }

}
