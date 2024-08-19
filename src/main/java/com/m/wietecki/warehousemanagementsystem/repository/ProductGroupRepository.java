package com.m.wietecki.warehousemanagementsystem.repository;

import com.m.wietecki.warehousemanagementsystem.model.product.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
    boolean existsByName(String name);
}
