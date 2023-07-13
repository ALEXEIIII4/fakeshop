package com.fakestore.demo.repository;

import com.fakestore.demo.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {
    List<CategoriesEntity> findAll();
}
