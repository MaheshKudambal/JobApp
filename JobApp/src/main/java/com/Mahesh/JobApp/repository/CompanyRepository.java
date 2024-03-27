package com.Mahesh.JobApp.repository;

import com.Mahesh.JobApp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
