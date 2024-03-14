package com.rfdev.habittracker.dtos;

import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.HabitRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HabitRecordResponseDTO extends HabitRecordRequestDTO {

  private LocalDateTime recordDate;

  public HabitRecordResponseDTO(HabitRecord habitRecord) {
    this.setHabitRecordId(habitRecord.getHabitRecordId());
    this.setRecordDate(habitRecord.getRecordDate());
    this.setStatus(habitRecord.getHabitStatus());
  }

  public HabitRecordResponseDTO(HabitRecord habitRecord, Habit habit) {
    this.setHabitRecordId(habitRecord.getHabitRecordId());
    this.setHabitDTO(new HabitDTO(habit));
    this.setRecordDate(habitRecord.getRecordDate());
    this.setStatus(habitRecord.getHabitStatus());
  }
}
