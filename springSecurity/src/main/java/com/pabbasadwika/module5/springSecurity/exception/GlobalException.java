package com.pabbasadwika.module5.springSecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(PostNotFound.class)
    public ResponseEntity<ErrorDto> handlePostNotFound(PostNotFound exception){

        ErrorDto postNotFound = new ErrorDto(
                LocalDateTime.now(),
                exception.getMessage(),
                (long) HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(postNotFound,HttpStatus.NOT_FOUND);

    }

}