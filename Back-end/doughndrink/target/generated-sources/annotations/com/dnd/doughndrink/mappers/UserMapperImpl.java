package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:15:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(UserDTO user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setUserId( user.getUserId() );
        if ( user.getFname() != null ) {
            user1.setFname( user.getFname() );
        }
        if ( user.getLname() != null ) {
            user1.setLname( user.getLname() );
        }
        if ( user.getEmail() != null ) {
            user1.setEmail( user.getEmail() );
        }
        if ( user.getPhone() != null ) {
            user1.setPhone( user.getPhone() );
        }
        if ( user.getAddress() != null ) {
            user1.setAddress( user.getAddress() );
        }
        if ( user.getRole() != null ) {
            user1.setRole( user.getRole() );
        }

        return user1;
    }

    @Override
    public UserDTO map(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getAddress() != null ) {
            userDTO.setAddress( user.getAddress() );
        }
        if ( user.getEmail() != null ) {
            userDTO.setEmail( user.getEmail() );
        }
        if ( user.getFname() != null ) {
            userDTO.setFname( user.getFname() );
        }
        if ( user.getLname() != null ) {
            userDTO.setLname( user.getLname() );
        }
        if ( user.getPhone() != null ) {
            userDTO.setPhone( user.getPhone() );
        }
        if ( user.getRole() != null ) {
            userDTO.setRole( user.getRole() );
        }
        userDTO.setUserId( user.getUserId() );

        return userDTO;
    }

    @Override
    public List<UserDTO> map(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( user.size() );
        for ( User user1 : user ) {
            list.add( map( user1 ) );
        }

        return list;
    }
}
