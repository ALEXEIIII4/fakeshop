package com.fakestore.demo.controller;

import com.fakestore.demo.dto.CategoriesDto;
import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/categories")
@AllArgsConstructor
public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> retrieveAllCategories() {
        return ResponseEntity.ok(categoriesService.getAllCategoriesNames());
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoriesEntity> retrieveCategories(@PathVariable String name) {
        return null;
    }

}
