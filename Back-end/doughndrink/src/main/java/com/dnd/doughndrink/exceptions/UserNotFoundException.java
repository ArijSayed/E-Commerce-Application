package com.dnd.doughndrink.exceptions;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException{
    @Getter
    private final String message;


    public UserNotFoundException(String message){
        super();
        this.message=message;
    }
  
}
