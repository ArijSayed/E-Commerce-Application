package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.models.User;

public interface UsersRoleRepository extends JpaRepository<User, Integer> {
   
}
