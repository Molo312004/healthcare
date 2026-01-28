package com.molier.HealthCare.service;

import com.molier.HealthCare.entities.Goal;
import com.molier.HealthCare.entities.User;
import com.molier.HealthCare.repository.GoalRepository;
import com.molier.HealthCare.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Optional;


@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public GoalService(GoalRepository goalRepository,
                       UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    public Goal createGoal(UUID userId, String title, String description,
                           int target, String timeframe) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Goal goal = new Goal();
        goal.setTitle(title);
        goal.setDescription(description);
        goal.setTarget(target);
        goal.setCurrent(0);
        goal.setTimeframe(timeframe);
        goal.setUser(user);

        return goalRepository.save(goal);
    }
}
