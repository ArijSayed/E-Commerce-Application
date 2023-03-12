package com.dnd.doughndrink.dtos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message,HttpStatus status,Object responsObject){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responsObject);

        return new ResponseEntity<Object>(map,status);

    }
    
}
