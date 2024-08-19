package com.m.wietecki.warehousemanagementsystem.repository;

import com.m.wietecki.warehousemanagementsystem.model.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
