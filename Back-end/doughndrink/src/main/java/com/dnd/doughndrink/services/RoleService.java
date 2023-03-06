package com.dnd.doughndrink.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.doughndrink.dtos.RoleDTO;
import com.dnd.doughndrink.mappers.RoleMapper;
import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {
    
    
   private final   RoleRepository  roleRepository;

   @Autowired
   private final RoleMapper roleMapper;

     //select
     public List<RoleDTO> findAll() {
    
        return roleMapper.map(roleRepository.findAll());
    }
    public RoleDTO findRoleById(int id){
        final Optional<Roles> optionalRoles = roleRepository.findById(id);
        return roleMapper.map(optionalRoles.get());
      }


}
