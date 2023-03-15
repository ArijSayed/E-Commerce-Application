package com.dnd.doughndrink.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.mappers.ProductMapper;
import com.dnd.doughndrink.mappers.SubCategoryMapper;
import com.dnd.doughndrink.models.Product;
import com.dnd.doughndrink.models.SubCategory;
import com.dnd.doughndrink.repositories.ProductRepository;
import com.dnd.doughndrink.repositories.SubCategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {


    // private final SubCategoryService subCategoryService;
   // private final SubCategoryRepository subCategoryRepository;

    private final ProductRepository productRepository;

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    private final ProductMapper productMapper;

    // private final SubCategoryMapper subCategoryMapper;

    @Autowired
    private final SubCategoryMapper subCategoryMapper;

   
    public ProductDTO findProductById(int product_id){
        
        Optional<Product> optionalProduct = productRepository.findById(product_id);
        return productMapper.map(optionalProduct.get());
    }

    public ProductDTO findProductByName(String product_name){
        
        Optional<Product> optionalProduct = productRepository.findByName(product_name);
        return productMapper.map(optionalProduct.get());
    }




    public List<ProductDTO> findAllProducts(){
       List<Product> products= productRepository.findAll();
       return productMapper.map(products);
    }

    // public void deletProduct(int product_id){
    //     productRepository.deleteById(product_id);
    // }


    public void deleteProduct(String name){
        productRepository.deleteByName(name);
    }

    // public void saveProduct(ProductDTO productDTO){
    //     Product product=productMapper.map(productDTO);
    //     productRepository.save(product);
    // }


    // public void updateProduct(int product_id){
    //    Optional<Product> optionalProduct=productRepository.findById(product_id);
    //    productRepository.save(optionalProduct.get());

    // public List<ProductDTO> findProductsBySubCategoryId(int sub_category_id){
    //     SubCategoryDTO subCategoryDTO=subCategoryService.findSubCategoryById(sub_category_id);
    //     SubCategory subCategory= subCategoryMapper.map(subCategoryDTO);
    //     Set<Product> products = subCategory.getProducts();
    //     return productMapper.map(products);
    // }

   

    // public void addProduct(ProductDTO productDTO){
    //     SubCategory subCategory = subCategoryRepository.findById(subCategoryMapper.map(productDTO.getSubCategory()).getSubCategoryId() ).orElse(null);
    //     if(null ==  subCategory){
    //         subCategory = new SubCategory();
    //     }

    //     Product product = productMapper.map(productDTO);

    //     subCategory.setSubCtgName(product.getSubCategory().getSubCtgName());
    //     product.setSubCategory(subCategory);
    //     productRepository.save(product);



    // }

    public void addProduct(ProductDTO productDTO){
        SubCategory subCategory = subCategoryRepository.findBySubCtgName(subCategoryMapper.map(productDTO.getSubCategory()).getSubCtgName() ).orElse(null);
        if(null ==  subCategory){
            subCategory = new SubCategory();
        }

        Product product = productMapper.map(productDTO);

        subCategory.setSubCtgName(product.getSubCategory().getSubCtgName());
        product.setSubCategory(subCategory);
        productRepository.save(product);


    }

    public List<ProductDTO> getProductBySubCategoryId(int sub_category_id){
        List<Product> products= productRepository.findAllBySubCategorySubCategoryId(sub_category_id);
        return productMapper.map(products); 
     }



}
