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
import org.springframework.web.bind.annotation.RestController;
import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
 
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") int product_id){
        return productService.findProductById(product_id);
    }

    @GetMapping
    public List<ProductDTO> findAllProducts(){
        return productService.findAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deletProduct(@PathVariable("id") int product_id){
        productService.deletProduct(product_id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO ){
        productService.saveProduct(productDTO);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
    }
}