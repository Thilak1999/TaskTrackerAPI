package com.takehome.TaskTracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InfoController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/info")
    public Map<String, String> info() {

        return Map.of(
                "appName", appName,
                "appVersion", appVersion
        );
    }
}