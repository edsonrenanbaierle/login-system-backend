package com.edsonbaierle.loginapi.infra.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserFoundException(UserFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.PRECONDITION_FAILED.value(),
                HttpStatus.PRECONDITION_FAILED.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(errorResponse);
    }
}

