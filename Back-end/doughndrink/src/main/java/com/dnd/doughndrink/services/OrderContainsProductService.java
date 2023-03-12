package com.dnd.doughndrink.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.doughndrink.dtos.OrderContainsProductDTO;
import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.mappers.OrderContainsProductMapper;
import com.dnd.doughndrink.models.OrderContainsProduct;
import com.dnd.doughndrink.repositories.OrderContainsProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderContainsProductService {

    private final   OrderContainsProductRepository  orderContainsProductRepository;

    @Autowired
    private   final OrderContainsProductMapper orderContainsProductMapper;
   //select
    public List<OrderContainsProductDTO> findAll() {
     
        return orderContainsProductMapper.map(orderContainsProductRepository.findAll());
        
    }
     // insert
 
     public void save(OrderContainsProductDTO orderContainsProductDTO) {
        final OrderContainsProduct orderContainsProduct = orderContainsProductMapper.map(orderContainsProductDTO);
        orderContainsProductRepository.save(orderContainsProduct);
     }
 
 
     public OrderContainsProductDTO findById(int orderId){
       final Optional<OrderContainsProduct> optionalordorderContainsProduct = orderContainsProductRepository.findById(orderId);
       return orderContainsProductMapper.map(optionalordorderContainsProduct.get());
     }
 
     
     public void deleteById(int orderId){
      orderContainsProductRepository.deleteById(orderId);    
     }
 
     
}