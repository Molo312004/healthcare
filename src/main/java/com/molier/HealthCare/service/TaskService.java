package com.molier.HealthCare.service;

import com.molier.HealthCare.entities.UserTask;
import com.molier.HealthCare.repository.TaskRepository;
import com.molier.HealthCare.repository.UserRepository;
import com.molier.HealthCare.entities.User;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public UserTask createTask(UUID userId, String title,
                           LocalDateTime dueDate, String priority) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserTask task = new UserTask();
        task.setTitle(title);
        task.setCompleted(false);
        task.setDueDate(dueDate);
        task.setPriority(priority);
        task.setUser(user);

        return taskRepository.save(task);
    }
}
