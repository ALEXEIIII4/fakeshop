package com.fakestore.demo.service.impl;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesServiceImpl {
    List<CategoriesDto> getAllCategoriesNames();

    CategoriesEntity getSingleCategorie();
}
