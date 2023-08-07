package com.fakestore.demo.controller;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.dto.goods.GoodsCreateDto;
import com.fakestore.demo.service.impl.GoodsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class GoodsController {

    private final GoodsServiceImpl goodsService;

    @GetMapping
    public List<GoodsDto> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @GetMapping("{id}")
    public GoodsDto getSingleGoods(@PathVariable Long id) {
        return goodsService.getSingleGoods(id);
    }

    @PostMapping
    public GoodsDto createGoods(@RequestBody GoodsCreateDto goodsCreateDto) {
        return goodsService.createGoods(goodsCreateDto);
    }

}
