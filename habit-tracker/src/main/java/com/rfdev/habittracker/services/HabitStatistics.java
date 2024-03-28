package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.HabitStatisticsDTO;
import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.HabitStatus;
import com.rfdev.habittracker.repositories.HabitRecordRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class HabitStatistics {

  private final HabitRecordRepository habitRecordRepository;

  public HabitStatistics(HabitRecordRepository habitRecordRepository) {
    this.habitRecordRepository = habitRecordRepository;
  }

  public HabitStatisticsDTO getHabitStatistics(Habit habit) {
    BigInteger habitGoal = habit.getGoal();
    BigInteger habitRecordsDone = habitRecordRepository.countByHabitHabitIdAndHabitStatus(habit.getHabitId(), HabitStatus.DONE);
    BigInteger habitRecordsNotDone = habitGoal.subtract(habitRecordsDone);
    BigDecimal percentageCompleted = calculateHabitPercentage(habitGoal, habitRecordsDone);
    return new HabitStatisticsDTO(habitGoal, habitRecordsDone, habitRecordsNotDone, percentageCompleted);
  }

  private BigDecimal calculateHabitPercentage(BigInteger habitGoal, BigInteger habitRecordsDone) {
    if (habitGoal.equals(BigInteger.ZERO)) return BigDecimal.ZERO;
    return new BigDecimal(habitRecordsDone).divide(new BigDecimal(habitGoal)).multiply(new BigDecimal(100));
  }
}
