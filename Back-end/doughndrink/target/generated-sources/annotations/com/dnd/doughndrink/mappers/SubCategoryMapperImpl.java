package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.models.SubCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:15:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategory map(SubCategoryDTO subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategory subCategory1 = new SubCategory();

        if ( subCategory.getSubCategoryId() != null ) {
            subCategory1.setSubCategoryId( subCategory.getSubCategoryId() );
        }
        if ( subCategory.getSubCtgName() != null ) {
            subCategory1.setSubCtgName( subCategory.getSubCtgName() );
        }

        return subCategory1;
    }

    @Override
    public SubCategoryDTO map(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        if ( subCategory.getSubCategoryId() != null ) {
            subCategoryDTO.setSubCategoryId( subCategory.getSubCategoryId() );
        }
        if ( subCategory.getSubCtgName() != null ) {
            subCategoryDTO.setSubCtgName( subCategory.getSubCtgName() );
        }

        return subCategoryDTO;
    }

    @Override
    public List<SubCategoryDTO> map(List<SubCategory> subcategory) {
        if ( subcategory == null ) {
            return null;
        }

        List<SubCategoryDTO> list = new ArrayList<SubCategoryDTO>( subcategory.size() );
        for ( SubCategory subCategory : subcategory ) {
            list.add( map( subCategory ) );
        }

        return list;
    }
}
