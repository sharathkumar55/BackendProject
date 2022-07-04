package com.example.assignment.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlinkListRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BlinkListErrorResponse> handleException(BlinkListNotFoundException exc){
        //create a BlinkListErrorResponse
        BlinkListErrorResponse error = new BlinkListErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return responsEntiry

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);


    }

    //catch all exceptions
    @ExceptionHandler
    public ResponseEntity<BlinkListErrorResponse> handleException(Exception exc){
        BlinkListErrorResponse error = new BlinkListErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return responsEntiry

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
