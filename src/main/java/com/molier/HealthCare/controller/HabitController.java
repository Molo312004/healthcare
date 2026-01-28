package com.molier.HealthCare.controller;

import com.molier.HealthCare.entities.Habit;
import com.molier.HealthCare.service.HabitService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "http://localhost:3000")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Habit> createHabit(
            @PathVariable UUID userId,
            @RequestBody Habit habit) {

        Habit savedHabit = habitService.createHabit(
                userId,
                habit.getName(),
                habit.getIcon(),
                habit.getGoal(),
                habit.getCategory(),
                habit.getWeekData()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(savedHabit);
    }
}
