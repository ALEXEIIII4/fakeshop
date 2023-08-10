package com.fakestore.demo.controller;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.service.CategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @Operation(
            summary = "Get all categories",
            description = "Get the list of all categories in FakeShop"
    )
    @GetMapping
    public List<CategoriesDto> retrieveAllCategories() {
        return categoriesService.getAllCategoriesNames();
    }

    @Operation(
            summary = "Get products in a specific category",
            description = "Get the list of products, but we need to choose category"
    )
    @GetMapping("/{name}")
    public List<GoodsDto> retrieveOneCategories(@PathVariable String name) {
        return categoriesService.getGoodsByCategoryName(name);
    }

}
