package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.HabitDTO;
import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.HabitRepository;
import com.rfdev.habittracker.repositories.UserRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class HabitService {

  @Autowired
  private HabitRepository habitRepository;

  @Autowired
  private UserRepository userRepository;

  @Transactional
  public Page<HabitDTO> findAllPaged(Pageable pageable) {
    Page<Habit> list = habitRepository.findAll(pageable);
    return list.map(HabitDTO::new);
  }

  @Transactional
  public HabitDTO findById(UUID habitId) {
    Optional<Habit> obj = habitRepository.findById(habitId);
    Habit habit = obj.orElseThrow(() -> new ResourceNotFoundException("Habit not Found"));
    return new HabitDTO(habit, habit.getUser());
  }

  @Transactional
  public HabitDTO update(UUID habitId, HabitDTO habitDTO) {
    try {
      Habit habit = habitRepository.getReferenceById(habitId);
      copyDtoToEntity(habitDTO, habit);
      habit = habitRepository.save(habit);
      return new HabitDTO(habit);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Habit not Found " + habitId);
    }
  }

  public void deleteHabit(UUID habitId) {
    Optional<Habit> obj = habitRepository.findById(habitId);
    Habit habit = obj.orElseThrow(() -> new ResourceNotFoundException("Habit not Found"));
    habitRepository.delete(habit);
  }

  private void copyDtoToEntity(HabitDTO dto, Habit entity) {
    User user = userRepository.getReferenceById(dto.getUser().getUserId());
    entity.setUser(user);
    entity.setHabitName(dto.getHabitName());
    entity.setDescription(dto.getDescription());
    entity.setStartDate(dto.getStartDate());
    entity.setGoal(dto.getGoal());
  }
}
