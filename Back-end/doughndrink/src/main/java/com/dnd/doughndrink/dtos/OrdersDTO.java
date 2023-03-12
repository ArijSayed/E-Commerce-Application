package com.dnd.doughndrink.dtos;

import java.util.Date;

import lombok.Data;
@Data
public class OrdersDTO {
    private Integer orderId;
    private String paymentType;
    private Date shippingDate;
    private Date orderDate;
    private Double totaPrice;
    private int userId;
}
