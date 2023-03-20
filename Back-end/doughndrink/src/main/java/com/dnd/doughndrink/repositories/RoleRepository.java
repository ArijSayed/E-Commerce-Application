package com.dnd.doughndrink.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles>   findByRoleName(String roleName);
}
