package com.dnd.doughndrink.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dnd.doughndrink.models.User;


@Repository
public interface UsersRoleRepository extends JpaRepository<User, Integer> {
   
}
