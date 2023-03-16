package com.dnd.doughndrink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.OrderContainsProductDTO;
import com.dnd.doughndrink.services.OrderContainsProductService;


@RestController
@RequestMapping("/ocp")
public class OrderContainsProductController {
    @Autowired
    private OrderContainsProductService orderContainsProductService;



    @PostMapping(consumes = "application/json")
    public void save(@RequestBody OrderContainsProductDTO orderContainsProductDTO){
        // System.out.println(orderContainsProductDTO.getId());
        System.out.println(orderContainsProductDTO.getOrders());
        System.out.println(orderContainsProductDTO.getProduct());
        System.out.println(orderContainsProductDTO.getQuntity());
    }


   @GetMapping
    public List<OrderContainsProductDTO> findAll(){
        return orderContainsProductService.findAll();
    }

    // @GetMapping("/{orderId}")
    // public OrderContainsProductDTO findOrderContainsProductIdById(@PathVariable int orderId){
    //     return orderContainsProductService.findById(orderId);
    // }

    //     @DeleteMapping("/{orderId}")
    //     public void deleteById(@PathVariable("orderId") int orderId) {
    //         orderContainsProductService.deleteById(orderId);
    // }

    // @PutMapping
    // public void  update( @RequestBody OrderContainsProductDTO orderContainsProductDTO) {
    //     orderContainsProductService.save(orderContainsProductDTO);
    // }
}
