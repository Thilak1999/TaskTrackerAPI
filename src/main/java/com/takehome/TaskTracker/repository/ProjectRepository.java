package com.takehome.TaskTracker.repository;


import com.takehome.TaskTracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}