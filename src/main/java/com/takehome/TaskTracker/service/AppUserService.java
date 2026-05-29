package com.takehome.TaskTracker.service;

import com.takehome.TaskTracker.dto.AppUserRequestDTO;
import com.takehome.TaskTracker.entity.AppUser;
import com.takehome.TaskTracker.exception.ResourceNotFoundException;
import com.takehome.TaskTracker.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public AppUser create(AppUserRequestDTO dto) {

        AppUser user = AppUser.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();

        return repository.save(user);
    }

    public List<AppUser> getAll() {

        return repository.findAll();
    }

    public AppUser getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));
    }

    public AppUser update(Long id,
                          AppUserRequestDTO dto) {

        AppUser user = getById(id);

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        return repository.save(user);
    }

    public void delete(Long id) {

        AppUser user = getById(id);

        repository.delete(user);
    }
}