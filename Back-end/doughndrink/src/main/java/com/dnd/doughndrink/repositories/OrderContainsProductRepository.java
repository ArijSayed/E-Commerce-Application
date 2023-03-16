package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.OrderContainsProduct;

public interface OrderContainsProductRepository extends JpaRepository<OrderContainsProduct, Integer> {
    
}
