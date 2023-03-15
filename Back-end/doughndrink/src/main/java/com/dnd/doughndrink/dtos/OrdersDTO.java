package com.dnd.doughndrink.dtos;

import java.util.Date;
import java.util.Set;

import com.dnd.doughndrink.models.OrderContainsProduct;

import lombok.Data;
@Data
public class OrdersDTO {
    private Integer orderId;
    private String paymentType;
    private Date shippingDate;
    private Date orderDate;
    private Double totalPrice;
    private UserDTO user;
    private Set<OrderContainsProductDTO> orderContainsProducts;
}
