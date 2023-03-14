package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.OrderContainsProductDTO;
import com.dnd.doughndrink.models.OrderContainsProduct;

@Component
@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderContainsProductMapper {
    OrderContainsProduct map(OrderContainsProductDTO orderContainsProduct);

    OrderContainsProductDTO map(OrderContainsProduct orderContainsProduct);

    List<OrderContainsProductDTO> map(List<OrderContainsProduct> orderContainsProduct);    
}