package com.dnd.doughndrink.dtos;


import lombok.Data;

@Data
public class ProductDTO {

    private Integer productId;
    private SubCategoryDTO subCategory;
    private String name;
    private String size;
    private float price;
    private String stock;
    private String description;
    private byte[] image;
    
    // public ProductDTO(String name, String size, float price, String stock,
    //         String description, byte[] image) {
    //     // this.subCategory.setSubCategoryId(subCategory_id);
    //     this.name = name;
    //     this.size = size;
    //     this.price = price;
    //     this.stock = stock;
    //     this.description = description;
    //     this.image=image;
    // }

    
    // private Set<OrderContainsProduct> orderContainsProducts = new HashSet<OrderContainsProduct>(0);
    // private Set<User> users = new HashSet<User>(0);

}
