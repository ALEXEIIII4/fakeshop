package com.fakestore.demo.controller;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.service.impl.CategoriesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
@AllArgsConstructor
public class CategoriesController {

    private final CategoriesServiceImpl categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> retrieveAllCategories() {
        return ResponseEntity.ok(categoriesService.getAllCategoriesNames());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<GoodsDto>> retrieveOneCategories(@PathVariable String name) {
        List<GoodsDto> goods = categoriesService.getGoodsByCategoryName(name);
        return ResponseEntity.ok(goods);
    }

}
