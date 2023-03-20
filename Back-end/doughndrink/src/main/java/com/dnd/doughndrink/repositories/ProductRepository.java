package com.dnd.doughndrink.repositories;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dnd.doughndrink.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{


        public List<Product> findAllBySubCategorySubCategoryId(int sub_category_id);
        public Optional<Product> findByName(String name);
        public void deleteByName(String name);

        
    
}
