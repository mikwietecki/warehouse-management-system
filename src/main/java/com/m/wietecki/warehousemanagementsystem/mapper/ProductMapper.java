package com.m.wietecki.warehousemanagementsystem.mapper;

import com.m.wietecki.warehousemanagementsystem.dto.ProductDto;
import com.m.wietecki.warehousemanagementsystem.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product productDtoToProduct(ProductDto productDto);
}
