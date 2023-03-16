package com.dnd.doughndrink.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.ResponseHandler;
import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.dtos.UsersRoleDTO;
import com.dnd.doughndrink.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/") 
public class UserController {
    @Autowired
    private UserService userService;


   @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }



    @GetMapping("/role")
    public List<UsersRoleDTO> getAll(){
        return userService.getAll();
    }




    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable int id){
        UserDTO user = userService.findUserById(id);
        return ResponseHandler.generateResponse("found user", HttpStatus.valueOf(200), user, true);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
   userService.deleteUserById(id);
}

// @PutMapping
//    public void  update( @RequestBody UserDTO userDTO) {
  
//     userService.save(userDTO);
//    }
    
}
