package com.fakestore.demo.dto;

import com.fakestore.demo.entity.CategoriesEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class GoodsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String price;

    CategoriesEntity categories;

    String description;


}
