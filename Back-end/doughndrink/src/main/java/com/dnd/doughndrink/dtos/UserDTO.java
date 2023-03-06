package com.dnd.doughndrink.dtos;

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
    //  private Map<Roles> roleses = new HashMap<Roles>(0);
    //  private Map<Product> products = new HashMap<Product>(0);
    //  private Map<Orders> orderses = new HashMap<Orders>(0);
    
}
