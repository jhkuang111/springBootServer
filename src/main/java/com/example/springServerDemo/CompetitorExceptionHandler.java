package com.example.springServerDemo;

import java.time.ZonedDateTime;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompetitorExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> playerNotFoundHandler (CompetitorNotFoundException ex, HttpServletRequest req) {
        ErrorResponse error = new ErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
