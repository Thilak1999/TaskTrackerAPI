package com.takehome.TaskTracker.controller;

import com.takehome.TaskTracker.dto.ProjectRequestDTO;
import com.takehome.TaskTracker.entity.Project;
import com.takehome.TaskTracker.entity.Task;
import com.takehome.TaskTracker.service.ProjectService;
import com.takehome.TaskTracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;
    private final TaskService taskService;

    public ProjectController(ProjectService service,
                             TaskService taskService) {
        this.service = service;
        this.taskService = taskService;
    }

    @PostMapping
    public Project create(
            @Valid @RequestBody ProjectRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping
    public List<Project> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Project update(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Project deleted successfully";
    }

    @GetMapping("/{id}/tasks")
    public List<Task> getTasksByProject(
            @PathVariable Long id) {

        return taskService.getByProject(id);
    }
//    @GetMapping
//    public Page<Project> getAll(
//
//            @RequestParam(defaultValue = "0")
//            int page,
//
//            @RequestParam(defaultValue = "5")
//            int size,
//
//            @RequestParam(defaultValue = "id")
//            String sortBy) {
//
//        return service.getAllProjects(
//                page,
//                size,
//                sortBy);
//    }
}