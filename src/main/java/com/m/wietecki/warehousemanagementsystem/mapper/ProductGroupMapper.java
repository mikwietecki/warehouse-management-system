package com.m.wietecki.warehousemanagementsystem.mapper;

import com.m.wietecki.warehousemanagementsystem.dto.ProductGroupDto;
import com.m.wietecki.warehousemanagementsystem.model.product.ProductGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductGroupMapper {
    ProductGroupMapper INSTANCE = Mappers.getMapper(ProductGroupMapper.class);

    ProductGroupDto groupToGroupDto(ProductGroup productGroup);

    @Mapping(target = "id", ignore = true)
    ProductGroup groupDtoToGroup(ProductGroupDto productGroupDto);
}
