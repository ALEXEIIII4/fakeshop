package com.fakestore.demo.service;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.dto.goods.GoodsCreateDto;
import com.fakestore.demo.entity.GoodsEntity;
import com.fakestore.demo.exception.ResourceNotFoundException;
import com.fakestore.demo.mapper.CategoriesMapper;
import com.fakestore.demo.mapper.GoodsMapper;
import com.fakestore.demo.repository.CategoriesRepository;
import com.fakestore.demo.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsService{

    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;
    private final CategoriesMapper categoriesMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public List<GoodsDto> getAllGoodsInDesc() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GoodsEntity> query = builder.createQuery(GoodsEntity.class);
        Root<GoodsEntity> root = query.from(GoodsEntity.class);
        query.select(root);

        query.orderBy(
                builder.desc(root.get("id"))
        );

        List<GoodsEntity> goodsEntities = entityManager.createQuery(query).getResultList();

        return goodsEntities.stream()
                .map(goodsMapper::goodsEntityToDto)
                .collect(Collectors.toList());
    }

    public List<GoodsDto> getAllGoodsInAsc() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GoodsEntity> query = builder.createQuery(GoodsEntity.class);
        Root<GoodsEntity> root = query.from(GoodsEntity.class);
        query.select(root);

        query.orderBy(
                builder.desc(root.get("id"))
        );

        List<GoodsEntity> goodsEntities = entityManager.createQuery(query).getResultList();

        return goodsEntities.stream()
                .map(goodsMapper::goodsEntityToDto)
                .collect(Collectors.toList());
    }

    public Page<GoodsDto> getGoodsPageable(Pageable pageable) {
        return goodsRepository.findAll(pageable).map(goodsMapper::goodsEntityToDto);
    }

    public GoodsDto getSingleGoods(Long id) {
        return goodsMapper.goodsEntityToDto(goodsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such product with: " + id)));
    }

    public GoodsDto createGoods(GoodsCreateDto createDto) {
        GoodsEntity entity = new GoodsEntity();
        entity.setTitle(createDto.getTitle());
        entity.setPrice(createDto.getPrice());
        entity.setCategory(categoriesMapper.categoriesDtoToEntity(createDto.getCategory()));
        entity.setDescription(createDto.getDescription());

        goodsRepository.save(entity);
        return goodsMapper.goodsEntityToDto(entity);
    }

    public GoodsDto updateGoods(GoodsDto goodsDto) {
        GoodsEntity goodsEntity = goodsRepository
                .findById(goodsDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("There is no such product: " + goodsDto.getTitle()));
        goodsEntity.setTitle(goodsDto.getTitle());
        goodsEntity.setPrice(goodsDto.getTitle());
        goodsEntity.setCategory(categoriesMapper.categoriesDtoToEntity(goodsDto.getCategory()));
        goodsEntity.setDescription(goodsDto.getDescription());

        goodsRepository.save(goodsEntity);
        return goodsMapper.goodsEntityToDto(goodsEntity);
    }

    public void deleteGoods(Long id) {
        GoodsEntity entity = goodsRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such product with ID: " + id));
        goodsRepository.delete(entity);
    }
}
