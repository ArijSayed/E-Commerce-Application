package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dtos.UserDTO;
import com.ecommerce.mappers.UserMapper;
import com.ecommerce.models.User;
import com.ecommerce.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;


// @Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
 @Autowired
   private final   UserRepository  userRepository;
   private   final UserMapper userMapper;
  //select
  //  public List<UserDTO> findAll() {
  //      return userMapper.map(
  //            userRepository.findAll()
  //      );
  //  }
    // insert

    public void save(UserDTO userDTO) {
        final User user=this.userMapper.map(userDTO);
      userRepository.save(user);
    }

    

    // update
    //delete 

}
