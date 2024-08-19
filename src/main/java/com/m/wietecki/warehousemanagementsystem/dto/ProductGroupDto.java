package com.m.wietecki.warehousemanagementsystem.dto;

import com.m.wietecki.warehousemanagementsystem.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGroupDto {
    private Long id;
    private String name;
    private List<Product> products;
}
