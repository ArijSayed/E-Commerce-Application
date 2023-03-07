package com.dnd.doughndrink.dtos;

import com.dnd.doughndrink.models.SubCategory;
import lombok.Data;

@Data
public class ProductDTO {
    private SubCategoryDTO subCategoryDTO;
    private Integer productId;
    private String name;
    private String size;
    private float price;
    private String stock;
    private String description;
    private byte[] image;
    
    public ProductDTO(SubCategoryDTO subCategoryDTO, String name, String size, float price, String stock,
            String description, byte[] image) {
        this.subCategoryDTO=subCategoryDTO;
        this.name = name;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.image=image;
    }
    
    // private Set<OrderContainsProduct> orderContainsProducts = new HashSet<OrderContainsProduct>(0);
    // private Set<User> users = new HashSet<User>(0);

}
