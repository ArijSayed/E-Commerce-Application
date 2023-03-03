package com.ecommerce.mappers;

import java.util.List;
import org.mapstruct.Mapper; 
import com.ecommerce.dtos.UserDTO;
import com.ecommerce.models.User;

@Mapper
public interface UserMapper {

    // @Mapping(target = "userid", source = "userid")

    // UserDTO map(User user);
    User map(UserDTO userDTO);

    // List<UserDTO> map(List<User> users);

    // List<UserDTO> map(UserDTO userDTO);


}
