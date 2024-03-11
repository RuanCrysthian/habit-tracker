package com.rfdev.habittracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_habit")
public class Habit implements Serializable {

  @Column(name = "habit_id")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID habitId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "habit_name")
  private String habitName;

  @Column(name = "description")
  private String description;

  @Column(name = "start_date")
  private Timestamp startDate;

  @Column(name = "goal")
  private BigInteger goal;
}
