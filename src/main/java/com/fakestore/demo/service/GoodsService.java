package com.fakestore.demo.service;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.dto.goods.GoodsCreateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService{

    List<GoodsDto> getAllGoods();
    GoodsDto getSingleGoods(Long id);
    GoodsDto createGoods(GoodsCreateDto createDto);
}
