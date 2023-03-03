package com.ecommerce;

import com.ecommerce.dtos.UserDTO;
import com.ecommerce.mappers.UserMapper;
import com.ecommerce.services.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        UserDTO user=new UserDTO();
        user.setFname("ali");
        user.setLname("ahmed");
        user.setAddress("cairo");
        user.setEmail("ali@gmail.com");
        user.setPhone("029078376");
        // user.setUserId(3);
       

        UserService userService=new  UserService(null,null);
        
        userService.save(user);

    }
}
