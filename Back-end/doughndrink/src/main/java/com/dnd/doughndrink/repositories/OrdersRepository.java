package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    
}
