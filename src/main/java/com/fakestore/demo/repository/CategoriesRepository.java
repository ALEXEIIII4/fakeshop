package com.fakestore.demo.repository;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {
    Optional<CategoriesEntity> findByName(String name);
}
