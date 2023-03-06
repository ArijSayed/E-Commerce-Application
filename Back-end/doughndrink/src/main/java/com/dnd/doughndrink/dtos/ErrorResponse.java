package com.dnd.doughndrink.dtos;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
    private  int code;
    private HttpStatus status;
    private String message;
    private String location;
}
