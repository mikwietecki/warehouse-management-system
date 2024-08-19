package com.m.wietecki.warehousemanagementsystem.service;

import com.m.wietecki.warehousemanagementsystem.dto.ProductDto;
import com.m.wietecki.warehousemanagementsystem.mapper.ProductMapper;
import com.m.wietecki.warehousemanagementsystem.model.product.Product;
import com.m.wietecki.warehousemanagementsystem.repository.ProductGroupRepository;
import com.m.wietecki.warehousemanagementsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, ProductGroupRepository productGroupRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAllProducts() {
        return productRepository.findAllByQuantityGreaterThan(0).stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findBySearchTerm(String searchTerm) {
        return productRepository.findByNameContainingIgnoreCase(searchTerm).stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByGroup(String groupName) {
        return productRepository.findByProductGroupContainingIgnoreCase(groupName).stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        if (productRepository.existsById(id)) {
            Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
            Product updatedProduct = productRepository.save(product);
            return ProductMapper.INSTANCE.productToProductDto(updatedProduct);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
