package com.ecommerce.mappers;

import com.ecommerce.dtos.UserDTO;
import com.ecommerce.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T23:38:18+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setFname( userDTO.getFname() );
        user.setLname( userDTO.getLname() );
        user.setEmail( userDTO.getEmail() );
        user.setPassward( userDTO.getPassward() );
        user.setPhone( userDTO.getPhone() );
        user.setAddress( userDTO.getAddress() );

        return user;
    }
}
