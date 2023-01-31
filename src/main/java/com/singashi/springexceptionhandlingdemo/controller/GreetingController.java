package com.singashi.springexceptionhandlingdemo.controller;

import com.singashi.springexceptionhandlingdemo.models.Greeting;
import com.singashi.springexceptionhandlingdemo.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

    @Autowired
    private final GreetingService greetingService;

    @PostMapping
    public ResponseEntity<String> postGreeting(@RequestBody Greeting greeting) {

        final String greetingMsg = "Hello";
        return ResponseEntity
                .accepted()
                .body(greetingMsg);
    }

//    @GetMapping("/error")
//    public ResponseEntity<?> throwException() {
//
//    }

    // working with controller level exception
    @ExceptionHandler
    public ResponseEntity<?> handleException(IllegalStateException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
