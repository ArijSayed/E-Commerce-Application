package com.dnd.doughndrink.models;
// Generated Mar 3, 2023, 7:32:16 PM by Hibernate Tools 6.0.0.Alpha2

 
import jakarta.persistence.*; 

/**
 * OrderContainsProduct generated by hbm2java
 */
@Entity
@Table(name="order_contains_product"
    ,catalog="doughndrink"
)
public class OrderContainsProduct  implements java.io.Serializable {


     private OrderContainsProductId id;
     private Orders orders;
     private Product product;
     private int quntity;

    public OrderContainsProduct() {
    }

    public OrderContainsProduct(OrderContainsProductId id, Orders orders, Product product, int quntity) {
       this.id = id;
       this.orders = orders;
       this.product = product;
       this.quntity = quntity;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="orderId", column=@Column(name="order_id", nullable=false) ), 
        @AttributeOverride(name="productId", column=@Column(name="product_id", nullable=false) ) } )
    public OrderContainsProductId getId() {
        return this.id;
    }
    
    public void setId(OrderContainsProductId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false, insertable=false, updatable=false)
    public Orders getOrders() {
        return this.orders;
    }
    
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Column(name="quntity", nullable=false)
    public int getQuntity() {
        return this.quntity;
    }
    
    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }




}

