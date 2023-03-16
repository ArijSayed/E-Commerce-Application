package com.dnd.doughndrink.models;
// Generated Mar 3, 2023, 7:32:16 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*; 
import static javax.persistence.GenerationType.IDENTITY;  

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="doughndrink"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Product  implements java.io.Serializable {


     private Integer productId;
     private SubCategory subCategory;
     private String name;
     private String size;
     private float price;
     private String stock;
     private String description;
     private byte[] image;
     private Set<OrderContainsProduct> orderContainsProducts = new HashSet<OrderContainsProduct>(0);
     @JsonBackReference
     private Set<User> users = new HashSet<User>(0);

    public Product() {
    }

	
    public Product(String name, String size, float price, String stock, String description) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
    public Product(SubCategory subCategory, String name, String size, float price, String stock, String description, byte[] image, Set<OrderContainsProduct> orderContainsProducts, Set<User> users) {
       this.subCategory = subCategory;
       this.name = name;
       this.size = size;
       this.price = price;
       this.stock = stock;
       this.description = description;
       this.image = image;
       this.orderContainsProducts = orderContainsProducts;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="product_id", unique=true, nullable=false)
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

@ManyToOne(fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name="sub_category_id")
    public SubCategory getSubCategory() {
        return this.subCategory;
    }
    
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    
    @Column(name="name", unique=true, nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="size", nullable=false, length=1)
    public String getSize() {
        return this.size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }

    
    @Column(name="price", nullable=false, precision=12, scale=0)
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    
    @Column(name="stock", nullable=false, length=15)
    public String getStock() {
        return this.stock;
    }
    
    public void setStock(String stock) {
        this.stock = stock;
    }

    
    @Column(name="description", nullable=false, length=500)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="image")
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<OrderContainsProduct> getOrderContainsProducts() {
        return this.orderContainsProducts;
    }
    
    public void setOrderContainsProducts(Set<OrderContainsProduct> orderContainsProducts) {
        this.orderContainsProducts = orderContainsProducts;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="products", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


