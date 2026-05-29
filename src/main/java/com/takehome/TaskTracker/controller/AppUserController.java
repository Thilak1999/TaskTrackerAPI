package com.takehome.TaskTracker.controller;

import com.takehome.TaskTracker.dto.AppUserRequestDTO;
import com.takehome.TaskTracker.entity.AppUser;
import com.takehome.TaskTracker.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public AppUser create(
            @Valid @RequestBody AppUserRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping
    public List<AppUser> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public AppUser getById(@PathVariable Long id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AppUser update(
            @PathVariable Long id,
            @Valid @RequestBody AppUserRequestDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "User deleted successfully";
    }
}