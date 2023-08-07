package com.fakestore.demo.mapper;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.entity.CategoriesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {
    CategoriesEntity categoriesDtoToEntity(CategoriesDto categoriesDto);

    CategoriesDto categoriesEntityToDto(CategoriesEntity categoriesEntity);
}
