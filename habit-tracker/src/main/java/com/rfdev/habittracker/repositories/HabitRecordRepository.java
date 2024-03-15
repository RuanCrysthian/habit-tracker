package com.rfdev.habittracker.repositories;

import com.rfdev.habittracker.models.HabitRecord;
import com.rfdev.habittracker.models.HabitStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface HabitRecordRepository extends JpaRepository<HabitRecord, UUID> {

  Page<HabitRecord> findByHabitHabitId(UUID habitId, Pageable pageable);

  BigInteger countByHabitHabitIdAndHabitStatus(UUID habitId, HabitStatus status);
}
