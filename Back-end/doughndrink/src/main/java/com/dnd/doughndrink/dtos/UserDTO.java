package com.dnd.doughndrink.dtos;

import java.util.HashSet;
import java.util.Set;

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
    //  private Set<RoleDTO> roleses = new HashSet<RoleDTO>(0);
   
     //  private Set<ProductDTO> products = new HashSet<ProductDTO>(0);
    //  private Map<Orders> orderses = new HashMap<Orders>(0);
    
}

