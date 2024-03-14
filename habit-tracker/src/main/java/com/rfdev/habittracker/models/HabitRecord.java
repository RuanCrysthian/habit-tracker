package com.rfdev.habittracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_habit_record")
public class HabitRecord implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "habit_record_id")
  private UUID habitRecordId;

  @ManyToOne
  @JoinColumn(name = "habit_id")
  private Habit habit;

  @Column(name = "record_date")
  private LocalDateTime recordDate;

  @Column(name = "habit_status")
  @Enumerated(EnumType.STRING)
  private HabitStatus habitStatus;

}
