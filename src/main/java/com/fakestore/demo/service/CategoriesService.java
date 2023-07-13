package com.fakestore.demo.service;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.repository.CategoriesRepository;
import com.fakestore.demo.service.impl.CategoriesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriesService implements CategoriesServiceImpl {

    private final CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesDto> getAllCategoriesNames() {
        List<CategoriesEntity> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesList = new ArrayList<>();
        for (CategoriesEntity category : categories) {
            CategoriesDto categoryDto = new CategoriesDto(category.getId(), category.getName());
            categoriesList.add(categoryDto);
        }
        return categoriesList;
    }

    @Override
    public CategoriesEntity getSingleCategorie() {
        return null;
    }
}
