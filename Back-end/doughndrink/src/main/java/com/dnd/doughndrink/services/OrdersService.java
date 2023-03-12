package com.dnd.doughndrink.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.mappers.OrdersMapper;
import com.dnd.doughndrink.mappers.UserMapper;
import com.dnd.doughndrink.models.Orders;
import com.dnd.doughndrink.repositories.OrdersRepository;

import com.dnd.doughndrink.repositories.UserRepository;


import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersService {

    private final   OrdersRepository  ordersRepository;

    @Autowired
    private   final OrdersMapper ordersMapper;

   //select
    public List<OrdersDTO> findAll() {
     
        return ordersMapper.map(ordersRepository.findAll()); 
    }

     // insert
 
     public void save(OrdersDTO ordersDTO) {
        final Orders orders = ordersMapper.map(ordersDTO);
       ordersRepository.save(orders);
     }
 
 
     public OrdersDTO findOrdersById(int orderId){
       final Optional<Orders> optionalOrders = ordersRepository.findById(orderId);
       return ordersMapper.map(optionalOrders.get());
     }
 
   

     public void deleteOrdersById(int orderId){
        ordersRepository.deleteById(orderId);    
     }
 
     public List<OrdersDTO> getOrdersbyUserId(int userId){
             List<Orders> orders= ordersRepository.findAllByUserUserId(userId);
             return ordersMapper.map(orders); 
          }
            
}
