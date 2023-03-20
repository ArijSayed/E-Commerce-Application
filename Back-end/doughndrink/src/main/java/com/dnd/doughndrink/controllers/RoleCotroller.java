package com.dnd.doughndrink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.RoleDTO;
import com.dnd.doughndrink.services.RoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/role")
public class RoleCotroller {
    @Autowired
    private RoleService roleService;


    @GetMapping
    public List<RoleDTO> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDTO findRoleById(@PathVariable int id){
        return roleService.findRoleById(id);
    }

   
    
}
