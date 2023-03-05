package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.models.User;

@Component
@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    User map(UserDTO user);

    UserDTO map(User user);

    List<UserDTO> map(List<User> user);
    
}
