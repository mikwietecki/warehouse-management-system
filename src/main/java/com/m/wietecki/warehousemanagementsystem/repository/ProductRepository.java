package com.m.wietecki.warehousemanagementsystem.repository;

import com.m.wietecki.warehousemanagementsystem.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByQuantityGreaterThan(int value);
    List<Product> findByNameContainingIgnoreCase(String searchTerm);
    List<Product> findByProductGroupContainingIgnoreCase(String groupName);
}
