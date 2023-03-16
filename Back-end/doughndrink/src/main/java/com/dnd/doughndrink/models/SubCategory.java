package com.dnd.doughndrink.models;
// Generated Mar 3, 2023, 7:32:16 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set; 
import static javax.persistence.GenerationType.IDENTITY; 

 
import javax.persistence.*; 

/**
 * SubCategory generated by hbm2java
 */
@Entity
@Table(name="sub_category"
    ,catalog="doughndrink"
    , uniqueConstraints = @UniqueConstraint(columnNames="sub_ctg_name") 
)
public class SubCategory  implements java.io.Serializable {


     private Integer subCategoryId;
     private Category category;
     private String subCtgName;
     private Set<Product> products = new HashSet<Product>(0);

    public SubCategory() {
    }

	
    public SubCategory(String subCtgName) {
        this.subCtgName = subCtgName;
    }
    public SubCategory(Category category, String subCtgName, Set<Product> products) {
       this.category = category;
       this.subCtgName = subCtgName;
       this.products = products;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="sub_category_id", unique=true, nullable=false)
    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }
    
    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    
    @Column(name="sub_ctg_name", unique=true, nullable=false, length=45)
    public String getSubCtgName() {
        return this.subCtgName;
    }
    
    public void setSubCtgName(String subCtgName) {
        this.subCtgName = subCtgName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subCategory")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


