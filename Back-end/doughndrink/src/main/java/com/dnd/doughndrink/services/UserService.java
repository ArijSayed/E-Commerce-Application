package com.dnd.doughndrink.services;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.dtos.UsersRoleDTO;
import com.dnd.doughndrink.exceptions.AlreadyExistException;
import com.dnd.doughndrink.mappers.RoleMapper;
import com.dnd.doughndrink.mappers.UserMapper;
import com.dnd.doughndrink.mappers.UsersRoleMapper;
import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.models.User;
import com.dnd.doughndrink.repositories.RoleRepository;
import com.dnd.doughndrink.repositories.UserRepository;
import com.dnd.doughndrink.repositories.UsersRoleRepository;

import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {


   private final   UserRepository  userRepository;
  private final UsersRoleRepository usersRoleRepository;

  private final RoleRepository roleRepository;

   @Autowired
   private   final UserMapper userMapper;
    @Autowired
   private final UsersRoleMapper usersRoleMapper;

   
   @Autowired
   private final RoleMapper roleMapper;
  //select
   public List<UserDTO> findAll() {
    
       return userMapper.map(userRepository.findAll());
       
   }
   
   public List<UsersRoleDTO>  getAll() {

    return usersRoleMapper.map(usersRoleRepository.findAll());
       
     
}
 
    // insert

    public void save(UserDTO userDTO) {
      final User user = userMapper.map(userDTO);
      userRepository.save(user);


    //   Set <Roles> roles = roleMapper.map(userDTO.getRoleses());
    //   List<Roles> rolesList = new ArrayList<Roles>(roles);
    //   String roleName = rolesList.get(0).getRoleName(); 
    //   Roles role = roleRepository.findByRoleName(roleName).orElse(null);
    //  User user = userMapper.map(userDTO);
    //   if(userRepository.existsByEmail(user.getEmail())){
    //     throw new AlreadyExistException("Email already used");
    //   }
    //   role.setRoleName(roleName);
    //   Set <Roles> userRoles = new HashSet<>();
    //   userRoles.add(role);
    //    user.setRoleses(userRoles);
    //  userRepository.save(user);
   }



    public UserDTO findUserById(int id){
      final Optional<User> optionalUser = userRepository.findById(id);
      return userMapper.map(optionalUser.get());
    }

    
    public void deleteUserById(int id){
       userRepository.deleteById(id);    
    }

    // update
    //delete 

}
