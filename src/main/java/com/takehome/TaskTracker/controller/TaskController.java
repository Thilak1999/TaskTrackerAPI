package com.takehome.TaskTracker.controller;


import com.takehome.TaskTracker.dto.TaskRequestDTO;
import com.takehome.TaskTracker.entity.Task;
import com.takehome.TaskTracker.enums.TaskStatus;
import com.takehome.TaskTracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(
            @Valid @RequestBody TaskRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping
    public List<Task> getAll(
            @RequestParam(required = false)
            TaskStatus status,

            @RequestParam(required = false)
            Long projectId) {

        if (status != null) {
            return service.getByStatus(status);
        }

        if (projectId != null) {
            return service.getByProject(projectId);
        }

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Task update(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequestDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Task deleted successfully";
    }
}