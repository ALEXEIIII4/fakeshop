package com.fakestore.demo.service;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.entity.CategoriesEntity;
import liquibase.pro.packaged.S;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDto> getAllCategoriesNames();

    List<GoodsDto> getGoodsByCategoryName(String name);
}
