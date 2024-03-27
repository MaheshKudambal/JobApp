package com.Mahesh.JobApp.repository;

import com.Mahesh.JobApp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(long companyId);
}
