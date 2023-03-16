package com.dnd.doughndrink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.services.SubCategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200/") 
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody SubCategoryDTO subCategoryDTO) {

        subCategoryService.save(subCategoryDTO);
    }

    @GetMapping
    public List<SubCategoryDTO> findAll() {
        return subCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public SubCategoryDTO findSubCategoryById(@PathVariable int id) {
        return subCategoryService.findSubCategoryById(id);
    }


    @GetMapping("/{name}")
    public SubCategoryDTO findSubCategoryById(@PathVariable String name) {
        return subCategoryService.findSubCtegoryByName(name);
    }

    @PutMapping
    public void update(@RequestBody SubCategoryDTO subcategoryDTO) {
        subCategoryService.save(subcategoryDTO);
    }

    @DeleteMapping("/{sub_category_id}")
    public void deleteSubCategoryById(@PathVariable("sub_category_id") int sub_category_id) {
        subCategoryService.deleteSubCategoryById(sub_category_id);
    }

}
