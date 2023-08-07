package com.fakestore.demo.mapper;

import com.fakestore.demo.dto.GoodsDto;
import com.fakestore.demo.entity.GoodsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsMapper {
    GoodsEntity goodsDtoToEntity(GoodsDto goodsDto);

    GoodsDto goodsEntityToDto(GoodsEntity goodsEntity);

}
