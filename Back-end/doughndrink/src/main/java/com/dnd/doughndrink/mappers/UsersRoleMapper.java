package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.UsersRoleDTO;
import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.models.User;

@Component
@Mapper(componentModel = "spring" ,
             nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
             nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsersRoleMapper {
    
    // User map(List<UsersRoleDTO> user);

    UsersRoleDTO map(User user);

    List<UsersRoleDTO> map(List<User> user);
}
