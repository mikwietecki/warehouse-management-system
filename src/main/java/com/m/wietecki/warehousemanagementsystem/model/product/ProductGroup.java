package com.m.wietecki.warehousemanagementsystem.model.product;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_group")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "productGroup")
    private List<Product> products;

    public void addProductToGroup(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        product.setProductGroup(this);
    }
}
