package com.dnd.doughndrink.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.mappers.ProductMapper;
import com.dnd.doughndrink.models.Product;
import com.dnd.doughndrink.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

   
    public ProductDTO findProductById(int product_id){
        
        Optional<Product> optionalProduct = productRepository.findById(product_id);
        return productMapper.map(optionalProduct.get());
    }

    public List<ProductDTO> findAllProducts(){
       List<Product> products= productRepository.findAll();
       return productMapper.map(products);
    }

    public void deletProduct(int product_id){
        productRepository.deleteById(product_id);
    }

    public void saveProduct(ProductDTO productDTO){
        Product product=productMapper.map(productDTO);
        productRepository.save(product);
    }

    // public void updateProduct(int product_id){
    //    Optional<Product> optionalProduct=productRepository.findById(product_id);
    //    productRepository.save(optionalProduct.get());
    // }


}
