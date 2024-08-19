package com.m.wietecki.warehousemanagementsystem.model.delivery;


import com.m.wietecki.warehousemanagementsystem.model.company.Company;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private LocalDate deliveryDate;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<DeliveryProduct> deliveryProducts;

    public void addDeliveryProduct(DeliveryProduct deliveryProduct) {
        if (deliveryProducts == null) {
            deliveryProducts = new ArrayList<>();
        }
        deliveryProducts.add(deliveryProduct);
        deliveryProduct.setDelivery(this);
    }
}
