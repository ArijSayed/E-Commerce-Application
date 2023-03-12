package com.dnd.doughndrink.dtos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dnd.doughndrink.models.Product;

// import java.util.*; 

// import java.util.Map;
// import com.ecommerce.models.Orders;
// import com.ecommerce.models.Product;
// import com.ecommerce.models.Roles;
// import lombok.Builder;
import lombok.Data;
// import lombok.RequiredArgsConstructor;

@Data 
public class UserDTO {
    private int userId;
     private String fname;
     private String lname;
     private String email;
     private String password;
     private String phone;
     private String address;
    //  private Set<Roles> roleses = new HashSet<Roles>(0);
     private Set<ProductDTO> products = new HashSet<ProductDTO>(0);
    //  private Set<Orders> orderses = new HashSet<Orders>(0);
    
}
