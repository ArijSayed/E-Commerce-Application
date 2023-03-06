package com.dnd.doughndrink.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getAddress());
        System.out.println(userDTO.getEmail());
        System.out.println(userDTO.getFname());
        System.out.println(userDTO.getLname());
        System.out.println(userDTO.getPassword());
        userService.save(userDTO);
    }


   @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
   userService.deleteUserById(id);
}

@PutMapping
   public void  update( @RequestBody UserDTO userDTO) {
    userService.save(userDTO);
   }
    
}
