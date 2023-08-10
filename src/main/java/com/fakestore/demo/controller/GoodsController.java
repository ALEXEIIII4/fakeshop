package com.fakestore.demo.controller;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.dto.goods.GoodsCreateDto;
import com.fakestore.demo.service.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @Operation(
            summary = "Get all products in desc by id",
            description = "Get all products in desc by id"
    )
    @GetMapping("/desc")
    public List<GoodsDto> getAllGoodsInDesc() {
        return goodsService.getAllGoodsInDesc();
    }
    @Operation(
            summary = "Get all products in asc by id",
            description = "Get all products in asc by id"
    )
    @GetMapping("/asc")
    public List<GoodsDto> getAllGoodsInAsc() {
        return goodsService.getAllGoodsInDesc();
    }

    @Operation(
            summary = "Get products limit",
            description = "Get all products with pageable value"
    )
    @GetMapping()
    public Page<GoodsDto> getGoodsPageable(@PageableDefault(value = 10) Pageable pageable) {
        return goodsService.getGoodsPageable(pageable);
    }

    @Operation(
            summary = "Get a single product",
            description = "Get a single product using id of product"
    )
    @GetMapping("{id}")
    public GoodsDto getSingleGoods(@PathVariable Long id) {
        return goodsService.getSingleGoods(id);
    }

    @Operation(
            summary = "Add new product",
            description = "Add new product, ID generated auto, other need to be written"
    )
    @PostMapping
    public GoodsDto createGoods(@RequestBody GoodsCreateDto goodsCreateDto) {
        return goodsService.createGoods(goodsCreateDto);
    }

    @Operation(
            summary = "Update a product",
            description = "Update a product"
    )
    @PutMapping
    public GoodsDto updateGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.updateGoods(goodsDto);
    }

    @Operation(
            summary = "Delete a product",
            description = "Delete a product by id of the product"
    )
    @DeleteMapping("{id}")
    public void deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
    }

}
