package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.models.Product;

// @Component
@Mapper(componentModel = "spring") 
public interface ProductMapper {

    Product map(ProductDTO productDto);

    ProductDTO map(Product product);

    List<ProductDTO> map(List<Product> products);
    
}
