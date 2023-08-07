package com.fakestore.demo.dto.goods;

import com.fakestore.demo.entity.CategoriesEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsCreateDto {

    String title;

    String price;

    CategoriesEntity categories;

    String description;

    public GoodsCreateDto(String title, String price, CategoriesEntity categories, String description) {
        this.title = title;
        this.price = price;
        this.categories = categories;
        this.description = description;
    }
}
