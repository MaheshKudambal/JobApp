package com.Mahesh.JobApp.repository;

import com.Mahesh.JobApp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
