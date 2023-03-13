package com.dnd.doughndrink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.dtos.ResponseHandler;
import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
 
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable("id") int product_id){
        try{
            ProductDTO result=productService.findProductById(product_id);
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, result,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, null,false);
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> findAllProducts(){
        try{
            List<ProductDTO> result=productService.findAllProducts();
            return ResponseHandler.generateResponse("Successfully retrieved data",HttpStatus.OK,result,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletProduct(@PathVariable("id") int product_id){
        try{
            productService.deletProduct(product_id);
            return ResponseHandler.generateResponse("Deleted!",HttpStatus.OK,null,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null,false);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDTO ){
        try{
        productService.addProduct(productDTO);
        return ResponseHandler.generateResponse("Successfully added data",HttpStatus.OK,null,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,false);
        }
        
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO productDTO){
        try{
            productService.addProduct(productDTO);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, null,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,false);
        }
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<Object> getProductBySubCategoryId(@PathVariable("id") int sub_category_id){
        try{
        List<ProductDTO> result= productService.getProductBySubCategoryId(sub_category_id);
        return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, result,true);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null,false);
        }
    }

}
