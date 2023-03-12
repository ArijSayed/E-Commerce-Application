package com.dnd.doughndrink.dtos;

import com.dnd.doughndrink.models.OrderContainsProductId;
import com.dnd.doughndrink.models.Orders;
import com.dnd.doughndrink.models.Product;

import lombok.Data;

@Data
public class OrderContainsProductDTO {
    private OrderContainsProductId id;
    private OrdersDTO orders;
    private ProductDTO product;
    private int quntity;
}
