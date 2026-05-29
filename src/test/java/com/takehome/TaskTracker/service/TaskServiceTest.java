package com.takehome.TaskTracker.service;


import com.takehome.TaskTracker.entity.Task;
import com.takehome.TaskTracker.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTasksTest() {

        List<Task> tasks = Arrays.asList(
                Task.builder().id(1L).title("Task1").build(),
                Task.builder().id(2L).title("Task2").build()
        );

        when(repository.findAll()).thenReturn(tasks);

        List<Task> result = service.getAll();

        assertEquals(2, result.size());
    }
}