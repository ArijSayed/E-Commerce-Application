package com.dnd.doughndrink.mappers;
  
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.RoleDTO;
import com.dnd.doughndrink.models.Roles;
@Component
@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface RoleMapper {
    

    Roles map(RoleDTO role);

    RoleDTO map(Roles role);

    List<RoleDTO> map(List<Roles> role);
}
