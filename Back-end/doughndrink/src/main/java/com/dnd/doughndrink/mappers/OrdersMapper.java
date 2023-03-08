package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.models.Orders;

@Component
@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrdersMapper {
    Orders map(OrdersDTO orders);

    OrdersDTO map(Orders orders);

    List<OrdersDTO> map(List<Orders> orders);    
}
