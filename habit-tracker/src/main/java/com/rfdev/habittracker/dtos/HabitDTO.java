package com.rfdev.habittracker.dtos;

import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class HabitDTO implements Serializable {

  private UUID habitId;

  private UserDTO user;

  @NotBlank(message = "Habit's name is Mandatory")
  private String habitName;

  private String description;

  @FutureOrPresent(message = "Start Date Should Be in Present or Future")
  @NotNull(message = "Start Date is Mandatory")
  private Timestamp startDate;

  @Positive(message = "Goal Should Be Positive")
  @NotNull(message = "Goal is Mandatory")
  private BigInteger goal;

  public HabitDTO(Habit habit) {
    this.habitId = habit.getHabitId();
    this.habitName = habit.getHabitName();
    this.description = habit.getDescription();
    this.startDate = habit.getStartDate();
    this.goal = habit.getGoal();
  }

  public HabitDTO(Habit habit, User user) {
    this(habit);
    this.user = new UserDTO(user);
  }
}
