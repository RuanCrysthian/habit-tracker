package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.HabitRecordRequestDTO;
import com.rfdev.habittracker.dtos.HabitRecordResponseDTO;
import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.HabitRecord;
import com.rfdev.habittracker.repositories.HabitRecordRepository;
import com.rfdev.habittracker.repositories.HabitRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class HabitRecordService {

  @Autowired
  private HabitRecordRepository habitRecordRepository;

  @Autowired
  private HabitRepository habitRepository;

  @Transactional
  public Page<HabitRecordResponseDTO> findAll(Pageable pageable) {
    Page<HabitRecord> habitRecords = habitRecordRepository.findAll(pageable);
    return habitRecords.map(HabitRecordResponseDTO::new);
  }

  @Transactional
  public HabitRecordResponseDTO findById(UUID habitRecordId) {
    Optional<HabitRecord> obj = habitRecordRepository.findById(habitRecordId);
    HabitRecord habitRecord = obj.orElseThrow(() -> new ResourceNotFoundException("Habit Record not Found"));
    return new HabitRecordResponseDTO(habitRecord, habitRecord.getHabit());
  }

  @Transactional
  public HabitRecordResponseDTO update(UUID habitRecordId, HabitRecordRequestDTO habitRecordRequestDTO) {
    try {
      HabitRecord habitRecord = habitRecordRepository.getReferenceById(habitRecordId);
      copyHabitRecordDtoToEntity(habitRecordRequestDTO, habitRecord);
      habitRecord = habitRecordRepository.save(habitRecord);
      return new HabitRecordResponseDTO(habitRecord, habitRecord.getHabit());
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Habit Record not Found");
    }
  }

  public void delete(UUID habitRecordId) {
    Optional<HabitRecord> obj = habitRecordRepository.findById(habitRecordId);
    HabitRecord habitRecord = obj.orElseThrow(() -> new ResourceNotFoundException("Habit Record not Found"));
    habitRecordRepository.delete(habitRecord);
  }

  private void copyHabitRecordDtoToEntity(HabitRecordRequestDTO dto, HabitRecord entity) {
    Habit habit = habitRepository.getReferenceById(dto.getHabitDTO().getHabitId());
    entity.setHabit(habit);
    entity.setRecordDate(LocalDateTime.now());
    entity.setHabitStatus(dto.getStatus());
  }
}
