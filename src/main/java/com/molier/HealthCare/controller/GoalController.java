package com.molier.HealthCare.controller;

import com.molier.HealthCare.entities.Goal;
import com.molier.HealthCare.service.GoalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "http://localhost:3000")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Goal> createGoal(
            @PathVariable UUID userId,
            @RequestBody Goal goal) {

        Goal savedGoal = goalService.createGoal(
                userId,
                goal.getTitle(),
                goal.getDescription(),
                goal.getTarget(),
                goal.getTimeframe()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(savedGoal);
    }
}
