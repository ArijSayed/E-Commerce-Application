package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.dtos.UserDTO;
import com.ecommerce.models.User; 

public interface UserRepository extends JpaRepository<User, Integer> {
   
}
