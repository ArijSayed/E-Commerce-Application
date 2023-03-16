package com.dnd.doughndrink.dtos;

import java.util.HashSet;
import java.util.Set;

import com.dnd.doughndrink.models.Roles;

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

    // RoleDTO role = new RoleDTO("ROLE_USER");
    private int userId;
     private String fname;
     private String lname;
     private String email;
     private String phone;
     private String address;
     private String role;
    //  private String role= "ROLE_USER";
    //  private Set<RoleDTO> roleses = new HashSet<RoleDTO>(){{
    //     add(role);
    //  }};

     

    // public UserDTO(String fname, String lname, String email, String password, String phone, String address,
    //         Set<RoleDTO> roles) {
               
    //     this.fname = fname;
    //     this.lname = lname;
    //     this.email = email;
    //     this.password = password;
    //     this.phone = phone;
    //     this.address = address;
    //     this.roleses = roles;
    // }
     
   
     //  private Set<ProductDTO> products = new HashSet<ProductDTO>(0);
    //  private Map<Orders> orderses = new HashMap<Orders>(0);
    
}

