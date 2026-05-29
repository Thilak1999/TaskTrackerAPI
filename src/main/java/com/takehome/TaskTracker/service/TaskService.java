package com.takehome.TaskTracker.service;

import com.takehome.TaskTracker.dto.TaskRequestDTO;
import com.takehome.TaskTracker.entity.AppUser;
import com.takehome.TaskTracker.entity.Project;
import com.takehome.TaskTracker.entity.Task;
import com.takehome.TaskTracker.enums.TaskPriority;
import com.takehome.TaskTracker.enums.TaskStatus;
import com.takehome.TaskTracker.exception.ResourceNotFoundException;
import com.takehome.TaskTracker.repository.AppUserRepository;
import com.takehome.TaskTracker.repository.ProjectRepository;
import com.takehome.TaskTracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final AppUserRepository userRepository;

    @Value("${task.default-priority}")
    private String defaultPriority;

    public TaskService(TaskRepository taskRepository,
                       ProjectRepository projectRepository,
                       AppUserRepository userRepository) {

        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Task create(TaskRequestDTO dto) {

        Project project = projectRepository
                .findById(dto.getProjectId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        AppUser assignee = null;

        if (dto.getAssigneeId() != null) {

            assignee = userRepository
                    .findById(dto.getAssigneeId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "User not found"));
        }

        Task task = Task.builder()
                .title(dto.getTitle())
                .status(dto.getStatus() == null ?
                        TaskStatus.TODO :
                        dto.getStatus())
                .priority(dto.getPriority() == null ?
                        TaskPriority.valueOf(defaultPriority) :
                        dto.getPriority())
                .dueDate(dto.getDueDate())
                .project(project)
                .assignee(assignee)
                .build();

        return taskRepository.save(task);
    }

    public List<Task> getAll() {

        return taskRepository.findAll();
    }

    public Task getById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found"));
    }

    public List<Task> getByStatus(TaskStatus status) {

        return taskRepository.findByStatus(status);
    }

    public List<Task> getByProject(Long projectId) {

        return taskRepository.findByProjectId(projectId);
    }

    public Task update(Long id,
                       TaskRequestDTO dto) {

        Task task = getById(id);

        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());

        return taskRepository.save(task);
    }

    public void delete(Long id) {

        Task task = getById(id);

        taskRepository.delete(task);
    }
}