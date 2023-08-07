package com.fakestore.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories", schema = "public")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoriesEntity(String name) {
        this.name = name;
    }

    public static CategoriesEntity createCategory(String name) {
        return new CategoriesEntity(name);
    }
}
