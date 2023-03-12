package com.dnd.doughndrink.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.services.SubCategoryService;

@RestController
@RequestMapping("/category")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody SubCategoryDTO subCategoryDTO){
       
        subCategoryService.save(subCategoryDTO);
    }
    
}
