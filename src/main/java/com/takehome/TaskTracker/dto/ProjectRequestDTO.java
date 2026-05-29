package com.takehome.TaskTracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProjectRequestDTO {

    @NotBlank
    private String name;
    private String description;
}