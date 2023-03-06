package com.dnd.doughndrink.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnd.doughndrink.dtos.ErrorResponse;
import com.dnd.doughndrink.exceptions.AlreadyExistException;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistException ex, HttpServletRequest req){
        String message = String.format("%s", ex.getMessage());


        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(HttpStatus.valueOf(409));
        errorResponse.setCode(409);
        errorResponse.setLocation(req.getRequestURI().toString());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());

    }
}
