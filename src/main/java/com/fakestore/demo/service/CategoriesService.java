package com.fakestore.demo.service;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.entity.GoodsEntity;
import com.fakestore.demo.exception.ResourceNotFoundException;
import com.fakestore.demo.mapper.GoodsMapper;
import com.fakestore.demo.repository.CategoriesRepository;
import com.fakestore.demo.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesService{

    private final CategoriesRepository categoriesRepository;
    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;

    public List<CategoriesDto> getAllCategoriesNames() {
        List<CategoriesEntity> categories = categoriesRepository.findAll();
        return categories.stream()
                .map(category -> new CategoriesDto(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    public List<GoodsDto> getGoodsByCategoryName(String name) {
        CategoriesEntity category = categoriesRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Do not have such category: " + name));
        List<GoodsEntity> goodsEntities = goodsRepository.findAllByCategory(category);
        return goodsEntities.stream()
                .map(goodsMapper::goodsEntityToDto)
                .collect(Collectors.toList());
    }

}
