package com.takehome.TaskTracker.dto;


import com.takehome.TaskTracker.enums.TaskPriority;
import com.takehome.TaskTracker.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDTO {

    @NotBlank
    private String title;

    private TaskStatus status;

    private TaskPriority priority;

    @NotNull
    private Long projectId;

    private Long assigneeId;

    private LocalDate dueDate;
}