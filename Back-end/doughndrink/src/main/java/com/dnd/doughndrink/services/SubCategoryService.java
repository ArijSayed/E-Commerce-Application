package com.dnd.doughndrink.services;

import java.util.List;
import java.util.Optional;

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

  private final SubCategoryRepository subCategoryRepository;

  @Autowired
  private final SubCategoryMapper subCategoryMapper;

  public void save(SubCategoryDTO subCategoryDTO) {
    final SubCategory subcategory = subCategoryMapper.map(subCategoryDTO);
    subCategoryRepository.save(subcategory);
  }

  public List<SubCategoryDTO> findAll() {

    return subCategoryMapper.map(subCategoryRepository.findAll());

  }

  public SubCategoryDTO findSubCategoryById(int id) {
    final Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(id);
    return subCategoryMapper.map(optionalSubCategory.get());
  }


  public SubCategoryDTO findSubCtegoryByName(String name){
    final Optional<SubCategory> optionalSubCategory = subCategoryRepository.findBySubCtgName(name);
    return subCategoryMapper.map(optionalSubCategory.get());
  }

  public void deleteSubCategoryById(int id) {
    subCategoryRepository.deleteById(id);
  }

  
}
