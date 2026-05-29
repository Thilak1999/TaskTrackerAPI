package com.takehome.TaskTracker.repository;


import com.takehome.TaskTracker.entity.Task;
import com.takehome.TaskTracker.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByProjectId(Long projectId);
}