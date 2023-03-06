package com.dnd.doughndrink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
   
}
