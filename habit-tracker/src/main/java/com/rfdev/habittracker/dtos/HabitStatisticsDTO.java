package com.rfdev.habittracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@Data
public class HabitStatisticsDTO implements Serializable {

  private BigInteger goal;
  private BigInteger habitRecordsDone;
  private BigInteger habitRecordsNotDone;
  private BigDecimal percentageCompleted;
}
