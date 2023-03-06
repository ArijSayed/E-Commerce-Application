package com.dnd.doughndrink.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.mappers.UserMapper;
import com.dnd.doughndrink.models.User;
import com.dnd.doughndrink.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {


   private final   UserRepository  userRepository;

   @Autowired
   private   final UserMapper userMapper;
  //select
   public List<UserDTO> findAll() {
    
       return userMapper.map(userRepository.findAll());
       
   }
    // insert

    public void save(UserDTO userDTO) {
       final User user = userMapper.map(userDTO);
      userRepository.save(user);
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
