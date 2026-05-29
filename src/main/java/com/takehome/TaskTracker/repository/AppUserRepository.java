package com.takehome.TaskTracker.repository;

import com.takehome.TaskTracker.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}