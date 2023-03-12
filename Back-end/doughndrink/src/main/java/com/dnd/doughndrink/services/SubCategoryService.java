package com.dnd.doughndrink.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.mappers.SubCategoryMapper;
import com.dnd.doughndrink.models.SubCategory;
import com.dnd.doughndrink.repositories.SubCategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final   SubCategoryRepository  subCategoryRepository;

   @Autowired
   private   final SubCategoryMapper subCategoryMapper;

   public void save(SubCategoryDTO subCategoryDTO) {
    final SubCategory user = subCategoryMapper.map(subCategoryDTO);
    
   subCategoryRepository.save(user);
 }
    
}
