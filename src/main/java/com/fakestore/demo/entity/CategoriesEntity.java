package com.fakestore.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Main entity to work with categories, have such fields as
 * ID, name
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories", schema = "public")
public class CategoriesEntity {
    @Schema(
            description = "ID of category",
            type = "long"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
            description = "name of category",
            type = "string"
    )
    private String name;
}
