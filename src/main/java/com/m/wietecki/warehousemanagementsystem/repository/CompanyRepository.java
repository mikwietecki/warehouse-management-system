package com.m.wietecki.warehousemanagementsystem.repository;

import com.m.wietecki.warehousemanagementsystem.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
