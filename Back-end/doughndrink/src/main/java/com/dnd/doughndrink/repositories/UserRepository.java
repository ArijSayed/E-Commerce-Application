package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dnd.doughndrink.models.User; 

public interface UserRepository extends JpaRepository<User, Integer> {
   
}
