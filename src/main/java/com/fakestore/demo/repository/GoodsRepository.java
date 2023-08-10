package com.fakestore.demo.repository;

import com.fakestore.demo.entity.CategoriesEntity;
import com.fakestore.demo.entity.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {
    List<GoodsEntity> findAllByCategory(CategoriesEntity categories);
    Page<GoodsEntity> findAll(Pageable pageable);
}
