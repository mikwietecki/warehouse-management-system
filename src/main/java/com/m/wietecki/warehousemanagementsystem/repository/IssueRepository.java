package com.m.wietecki.warehousemanagementsystem.repository;

import com.m.wietecki.warehousemanagementsystem.model.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
