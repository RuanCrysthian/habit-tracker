package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.*;
import com.rfdev.habittracker.models.Habit;
import com.rfdev.habittracker.models.Role;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.HabitRepository;
import com.rfdev.habittracker.repositories.RoleRepository;
import com.rfdev.habittracker.repositories.UserRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final BCryptPasswordEncoder passwordEncoder;

  private final HabitRepository habitRepository;

  private static final String USER_NOT_FOUND = "User not Found";

  public UserService(UserRepository userRepository,
                     RoleRepository roleRepository,
                     BCryptPasswordEncoder passwordEncoder,
                     HabitRepository habitRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.habitRepository = habitRepository;
  }

  @Transactional
  public Page<UserDTO> findAllPaged(Pageable pageable) {
    Page<User> list = userRepository.findAll(pageable);
    return list.map(UserDTO::new);
  }

  @Transactional(readOnly = true)
  public UserDTO findById(UUID userId) {
    Optional<User> obj = userRepository.findById(userId);
    User entity = obj.orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    return new UserDTO(entity);
  }

  @Transactional
  public UserDTO insert(UserInsertDTO dto) {
    User entity = new User();
    copyDtoToEntity(dto, entity);
    entity.setPassword(passwordEncoder.encode(dto.getPassword()));
    entity = userRepository.save(entity);
    return new UserDTO(entity);
  }

  @Transactional
  public UserDTO update(UUID userId, UserUpdateDTO dto) {
    try {
      User entity = userRepository.getReferenceById(userId);
      copyDtoToEntity(dto, entity);
      entity = userRepository.save(entity);
      return new UserDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(USER_NOT_FOUND);
    }
  }

  public void delete(UUID userId) {
    try {
      userRepository.deleteById(userId);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(USER_NOT_FOUND);
    }
  }

  @Transactional
  public HabitDTO insertHabit(UUID userId, HabitDTO habitDTO) {
    try {
      User user = userRepository.getReferenceById(userId);
      Habit habit = new Habit();
      copyHabitDtoToEntity(user, habitDTO, habit);
      habit = habitRepository.save(habit);
      return new HabitDTO(habit, user);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(USER_NOT_FOUND);
    }
  }

  @Transactional
  public Page<HabitDTO> findAllHabitsByUserId(UUID userId, Pageable pageable) {
    Page<Habit> list = habitRepository.findByUserUserId(userId, pageable);
    return list.map(HabitDTO::new);
  }

  private void copyDtoToEntity(UserDTO dto, User entity) {
    entity.setName(dto.getName());
    entity.setUsername(dto.getUsername());
    entity.setEmail(dto.getEmail());

    entity.getRoles().clear();
    for (RoleDTO roleDTO : dto.getRoles()) {
      Role role = roleRepository.getReferenceById(roleDTO.getRoleId());
      entity.getRoles().add(role);
    }
  }

  private void copyHabitDtoToEntity(User user, HabitDTO habitDTO, Habit habit) {
    habit.setUser(user);
    habit.setHabitName(habitDTO.getHabitName());
    habit.setDescription(habitDTO.getDescription());
    habit.setStartDate(habitDTO.getStartDate());
    habit.setGoal(habitDTO.getGoal());
  }
}
