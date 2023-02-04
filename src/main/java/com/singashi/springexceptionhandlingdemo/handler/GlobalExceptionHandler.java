package com.singashi.springexceptionhandlingdemo.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // working with controller level exception
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<?> handleException() {
//        return ResponseEntity
//                .notFound()
//                .build();
//    }

}
