package com.molier.HealthCare.repository;

import com.molier.HealthCare.entities.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TaskRepository extends JpaRepository<UserTask, UUID> {
}
