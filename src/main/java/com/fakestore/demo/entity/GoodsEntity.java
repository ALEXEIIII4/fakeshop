package com.fakestore.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Main entity for products of shop with fields
 * ID, title, price, category, description
 * Field category is another Entity called CategoriesEntity with relation many to one,
 * because we can have a lot of products with same ID
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods", schema = "public")
public class GoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID of every product",
            type = "long"
    )
    Long id;
    @Schema(
            description = "title of the product",
            type = "string"
    )
    String title;
    @Schema(
            description = "price of the product",
            type = "string"
    )
    String price;

    @Schema(
            description = "category of product",
            type = "object"
    )
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "categories_id")
    CategoriesEntity category;

    @Schema(
            description = "description of product",
            type = "string"
    )
    String description;

    // TODO: 14.07.2023 Сделать хранение картинок. Вопрос, хранить картинки нужно в  byte[]?


}
