package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.HabitDTO;
import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.repositories.HabitRepository;
import com.rfdev.habittracker.repositories.UserRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
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
}
