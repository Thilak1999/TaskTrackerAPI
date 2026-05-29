package com.takehome.TaskTracker.service;

import com.takehome.TaskTracker.dto.ProjectRequestDTO;
import com.takehome.TaskTracker.entity.Project;
import com.takehome.TaskTracker.exception.ResourceNotFoundException;
import com.takehome.TaskTracker.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(ProjectRequestDTO dto) {

        Project project = Project.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        return repository.save(project);
    }

    public List<Project> getAll() {

        return repository.findAll();
    }

    public Project getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));
    }

    public Project update(Long id,
                          ProjectRequestDTO dto) {

        Project project = getById(id);

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());

        return repository.save(project);
    }

    public void delete(Long id) {

        Project project = getById(id);

        repository.delete(project);
    }
    public Page<Project> getAllProjects(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy));

        return repository.findAll(pageable);
    }
}