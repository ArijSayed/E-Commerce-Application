package com.dnd.doughndrink.models;
// Generated Mar 3, 2023, 7:32:16 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set; 
 
import javax.persistence.*; 

/**
 * User generated by hbm2java
 */


@Entity
@Table(name="user"
    ,catalog="doughndrink"
    , uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="phone")} 
)
 

public class User  implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int userId;
     private String fname;
     private String lname;
     private String email;
     private String password;
    private String phone;
     private String address;
     private String role;
     private Set<Roles> roleses = new HashSet<Roles>(0);
     private Set<Product> products = new HashSet<Product>(0);
     private Set<Orders> orderses = new HashSet<Orders>(0);

    public User() {
    }

	
    public User(int userId, String fname, String lname, String email, String password, String phone, String address) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
    public User(int userId, String fname, String lname, String email, String password, String phone, String address, Set<Roles> roleses, Set<Product> products, Set<Orders> orderses) {
       this.userId = userId;
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.password = password;
       this.phone = phone;
       this.address = address;
       this.roleses = roleses;
       this.products = products;
       this.orderses = orderses;
    }


     
    public User( String fname, String lname, String email, String password, String phone, String address,String role) {
   
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role=role;
 
    }
   
     @Id 
    @Column(name="user_id", unique=true, nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    @Column(name="fname", nullable=false, length=30)
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    
    @Column(name="lname", nullable=false, length=30)
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    
    @Column(name="email", unique=true, nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", nullable=false, length=15)
    public String getpassword() {
        return this.password;
    }
    
    public void setpassword(String password) {
        this.password = password;
    }

    
    @Column(name="phone", unique=true, nullable=false, length=15)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="address", nullable=false, length=300)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_has_role", catalog="doughndrink", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) })
    public Set<Roles> getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set<Roles> roleses) {
        this.roleses = roleses;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_buy_product", catalog="doughndrink", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="product_id", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @Column(name="role", length=255)
    public String getRole() {
       return role;
   }


   public void setRole(String role) {
       this.role = role;
   }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
                + password + ", phone=" + phone + ", address=" + address + "]";
    }




}


