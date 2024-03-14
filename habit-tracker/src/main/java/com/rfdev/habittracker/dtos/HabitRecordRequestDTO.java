package com.rfdev.habittracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rfdev.habittracker.models.HabitStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HabitRecordRequestDTO implements Serializable {

  private UUID habitRecordId;

  private HabitDTO habitDTO;

  @NotNull(message = "Status is Mandatory")
  private HabitStatus status;
}
