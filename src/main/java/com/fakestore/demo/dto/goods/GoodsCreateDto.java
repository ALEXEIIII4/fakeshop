package com.fakestore.demo.dto.goods;

import com.fakestore.demo.dto.CategoriesDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class GoodsCreateDto {
    @NotNull
    String title;

    @NotNull
    String price;

    @NotNull
    CategoriesDto category;

    String description;
}
