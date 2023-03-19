package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.models.Product;
import com.dnd.doughndrink.models.SubCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:19:35+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product map(ProductDTO productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setDescription( productDto.getDescription() );
        product.setImage( productDto.getImage() );
        product.setName( productDto.getName() );
        product.setPrice( productDto.getPrice() );
        product.setProductId( productDto.getProductId() );
        product.setSize( productDto.getSize() );
        product.setStock( productDto.getStock() );
        product.setSubCategory( subCategoryDTOToSubCategory( productDto.getSubCategory() ) );

        return product;
    }

    @Override
    public ProductDTO map(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setDescription( product.getDescription() );
        productDTO.setImage( product.getImage() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setProductId( product.getProductId() );
        productDTO.setSize( product.getSize() );
        productDTO.setStock( product.getStock() );
        productDTO.setSubCategory( subCategoryToSubCategoryDTO( product.getSubCategory() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> map(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( map( product ) );
        }

        return list;
    }

    protected SubCategory subCategoryDTOToSubCategory(SubCategoryDTO subCategoryDTO) {
        if ( subCategoryDTO == null ) {
            return null;
        }

        SubCategory subCategory = new SubCategory();

        subCategory.setSubCategoryId( subCategoryDTO.getSubCategoryId() );
        subCategory.setSubCtgName( subCategoryDTO.getSubCtgName() );

        return subCategory;
    }

    protected SubCategoryDTO subCategoryToSubCategoryDTO(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        subCategoryDTO.setSubCategoryId( subCategory.getSubCategoryId() );
        subCategoryDTO.setSubCtgName( subCategory.getSubCtgName() );

        return subCategoryDTO;
    }
}
