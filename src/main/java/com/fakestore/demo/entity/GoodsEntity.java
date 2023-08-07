package com.fakestore.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods", schema = "public")
public class GoodsEntity {
    @Id
    Long id;

    String title;

    String price;

    @OneToOne
    @JoinColumn(name = "categories_id")
    CategoriesEntity categories;

    String description;

    // TODO: 14.07.2023 Сделать хранение картинок. Вопрос, хранить картинки нужно в  byte[]?


}
