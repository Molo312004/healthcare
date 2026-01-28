package com.molier.HealthCare.controller;

import com.molier.HealthCare.entities.UserTask;
import com.molier.HealthCare.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserTask> createTask(
            @PathVariable UUID userId,
            @RequestBody UserTask task) {

        UserTask savedTask = taskService.createTask(
                userId,
                task.getTitle(),
                task.getDueDate(),
                task.getPriority()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
}
