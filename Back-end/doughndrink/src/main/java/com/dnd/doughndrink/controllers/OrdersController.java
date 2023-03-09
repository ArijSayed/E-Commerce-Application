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

import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.services.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService OrdersService;

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.getPaymentType());
        System.out.println(ordersDTO.getShippingDate());
        System.out.println(ordersDTO.getOrderDate());
        System.out.println(ordersDTO.getUserId());
        System.out.println(ordersDTO.getTotaPrice());
        OrdersService.save(ordersDTO);
    }


   @GetMapping
    public List<OrdersDTO> findAll(){
        return OrdersService.findAll();
    }

    @GetMapping("/{orderId}")
    public OrdersDTO findOrdersById(@PathVariable int orderId){
        return OrdersService.findOrdersById(orderId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrdersById(@PathVariable("orderId") int orderId) {
        OrdersService.deleteOrdersById(orderId);
}

@PutMapping
   public void  update( @RequestBody OrdersDTO ordersDTO) {
    OrdersService.save(ordersDTO);
   }
}