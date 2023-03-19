package com.dnd.doughndrink.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.models.SubCategory;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SubCategoryMapper {

    SubCategory map(SubCategoryDTO subCategory);

    SubCategoryDTO map(SubCategory subCategory);

    List<SubCategoryDTO> map(List<SubCategory> subcategory);

}
