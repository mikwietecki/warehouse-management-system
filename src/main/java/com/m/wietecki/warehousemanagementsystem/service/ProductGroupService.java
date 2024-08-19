package com.m.wietecki.warehousemanagementsystem.service;

import com.m.wietecki.warehousemanagementsystem.dto.ProductGroupDto;
import com.m.wietecki.warehousemanagementsystem.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;

    public ProductGroupService(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    public ProductGroupDto addGroup(String name) {
        if (productGroupRepository.existsByName(name)) {
            throw new IllegalArgumentException("Product group with name " + name + " already exists");
        }
    }
}
