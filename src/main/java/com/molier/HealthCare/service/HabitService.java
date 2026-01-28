package com.molier.HealthCare.service;

import com.molier.HealthCare.entities.Habit;
import com.molier.HealthCare.entities.User;
import com.molier.HealthCare.repository.HabitRepository;
import com.molier.HealthCare.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository,
                        UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    public Habit createHabit(UUID userId, String name, String icon,
                             int goal, String category, String weekDataJson) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Habit habit = new Habit();
        habit.setName(name);
        habit.setIcon(icon);
        habit.setGoal(goal);
        habit.setCompleted(0);
        habit.setCategory(category);
        habit.setWeekData(weekDataJson);
        habit.setUser(user);

        return habitRepository.save(habit);
    }
}
