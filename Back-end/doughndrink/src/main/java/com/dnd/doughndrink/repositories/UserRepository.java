package com.dnd.doughndrink.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.User; 

public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
