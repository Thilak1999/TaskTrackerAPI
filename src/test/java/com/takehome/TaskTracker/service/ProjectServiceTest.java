package com.takehome.TaskTracker.service;


import com.takehome.TaskTracker.dto.ProjectRequestDTO;
import com.takehome.TaskTracker.entity.Project;
import com.takehome.TaskTracker.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @Mock
    private ProjectRepository repository;

    @InjectMocks
    private ProjectService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProjectTest() {

        ProjectRequestDTO dto = new ProjectRequestDTO();
        dto.setName("Backend API");
        dto.setDescription("Spring Boot");

        Project savedProject = Project.builder()
                .id(1L)
                .name("Backend API")
                .description("Spring Boot")
                .build();

        when(repository.save(any(Project.class)))
                .thenReturn(savedProject);

        Project result = service.create(dto);

        assertNotNull(result);
        assertEquals("Backend API", result.getName());
    }

    @Test
    void getAllProjectsTest() {

        List<Project> projects = Arrays.asList(
                Project.builder().id(1L).name("P1").build(),
                Project.builder().id(2L).name("P2").build()
        );

        when(repository.findAll()).thenReturn(projects);

        List<Project> result = service.getAll();

        assertEquals(2, result.size());
    }
}