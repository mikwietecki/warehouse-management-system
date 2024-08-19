package com.m.wietecki.warehousemanagementsystem.model.issue;

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
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private LocalDate issueDate;
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<IssueProduct> issueProducts;

    public void addIssueProduct(IssueProduct issueProduct) {
        if (issueProducts == null) {
            issueProducts = new ArrayList<>();
        }
        issueProducts.add(issueProduct);
        issueProduct.setIssue(this);
    }
}
