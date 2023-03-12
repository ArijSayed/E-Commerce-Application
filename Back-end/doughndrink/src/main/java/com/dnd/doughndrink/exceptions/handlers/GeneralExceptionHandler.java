package com.dnd.doughndrink.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnd.doughndrink.dtos.ErrorResponse;
import com.dnd.doughndrink.dtos.ResponseHandler;
import com.dnd.doughndrink.exceptions.AlreadyExistException;
import com.dnd.doughndrink.exceptions.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException ex, HttpServletRequest req){
        String message = String.format("%s", ex.getMessage());
        return ResponseHandler.generateResponse(message, HttpStatus.valueOf(409), 409);

    }



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest req){
        String message = String.format("%s", ex.getMessage());
        return ResponseHandler.generateResponse(message, HttpStatus.valueOf(401), 401);

    }
}
