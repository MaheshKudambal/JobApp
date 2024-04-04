package com.Mahesh.JobApp.repository;

import com.Mahesh.JobApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
