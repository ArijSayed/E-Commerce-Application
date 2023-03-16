package com.dnd.doughndrink.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnd.doughndrink.models.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer>{ 
    Optional<SubCategory> findBySubCtgName(String subCtgName);
}
