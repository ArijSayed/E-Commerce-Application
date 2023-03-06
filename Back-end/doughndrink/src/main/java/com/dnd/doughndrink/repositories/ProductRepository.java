package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    
    
}
