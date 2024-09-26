package com.wiemanboy.wiemanapi.presentation;

import com.wiemanboy.wiemanapi.domain.exceptions.ProfileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${debug:false}")
    private boolean debug;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        if (debug) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred");
    }

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<String> handleProfileNotFoundException(ProfileNotFoundException exception) {
        String body = "Profile not found";

        if (exception.getName() != null) {
            body = String.format("Profile with name %s not found", exception.getName());
        }
        if (exception.getId() != null) {
            body = String.format("Profile with id %s not found", exception.getId());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
