package com.dnd.doughndrink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.models.Orders;
import com.dnd.doughndrink.services.OrdersService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200/") 
public class OrdersController {
    @Autowired
    private OrdersService OrdersService;
    // @Autowired(required = true)
    // private Orders orders;
    private OrdersDTO ordersDTO;


    @PostMapping(consumes = "application/json")
    public void save(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.getPaymentType());
        System.out.println(ordersDTO.getShippingDate());
        System.out.println(ordersDTO.getOrderDate());
        System.out.println(ordersDTO.getUser());
        System.out.println(ordersDTO.getTotalPrice());
        OrdersService.save(ordersDTO);
    }


   @GetMapping
    public List<OrdersDTO> findAll(){
        // double total = OrdersService.totalPrice();
        // ordersDTO.setTotalPrice(total);
        return OrdersService.findAll();
    }

    @GetMapping("/{orderId}")
    public OrdersDTO findOrdersById(@PathVariable int orderId){
        // double total = OrdersService.totalPrice();
        // ordersDTO.setTotalPrice(total);
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

   @GetMapping("/user/{id}")
       public List<OrdersDTO> getOrdersbyUserId(@PathVariable("id") int userId){
          return OrdersService.getOrdersbyUserId(userId);
       }

}
