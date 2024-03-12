package com.rfdev.habittracker.repositories;

import com.rfdev.habittracker.models.Habit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HabitRepository extends JpaRepository<Habit, UUID> {

  Page<Habit> findByUserUserId(UUID userId, Pageable pageable);
}
