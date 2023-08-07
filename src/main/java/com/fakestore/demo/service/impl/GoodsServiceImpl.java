package com.fakestore.demo.service.impl;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.dto.goods.GoodsCreateDto;
import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.entity.GoodsEntity;
import com.fakestore.demo.exception.ResourceNotFoundException;
import com.fakestore.demo.mapper.GoodsMapper;
import com.fakestore.demo.repository.CategoriesRepository;
import com.fakestore.demo.repository.GoodsRepository;
import com.fakestore.demo.service.GoodsService;
import liquibase.pro.packaged.G;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;
    private final CategoriesRepository categoriesRepository;

    @Override
    public List<GoodsDto> getAllGoods() {
        List<GoodsEntity> entities = goodsRepository.findAll();
        return entities.stream().map(goodsMapper::goodsEntityToDto).collect(Collectors.toList());
    }

    @Override
    public GoodsDto getSingleGoods(Long id) {
        GoodsEntity entity =  goodsRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such product with: " + id));
        return goodsMapper.goodsEntityToDto(entity);
    }

    @Override
    public GoodsDto createGoods(GoodsCreateDto createDto) {
        if (createDto.getCategories().equals(categoriesRepository.findByName(createDto.getCategories().getName()))) {
            throw new ResourceNotFoundException("There is no such category: " + createDto.getCategories());
        }

        GoodsEntity entity = new GoodsEntity();
        entity.setTitle(createDto.getTitle());
        entity.setPrice(createDto.getPrice());
        entity.setCategories(createDto.getCategories());
        entity.setDescription(createDto.getDescription());

        return goodsMapper.goodsEntityToDto(entity);
    }
}
