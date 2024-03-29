package com.dnd.doughndrink.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
   
    public List<Orders> findAllByUserUserId(int userId);
}
