package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.RoleDTO;
import com.rfdev.habittracker.dtos.UserDTO;
import com.rfdev.habittracker.dtos.UserInsertDTO;
import com.rfdev.habittracker.dtos.UserUpdateDTO;
import com.rfdev.habittracker.models.Role;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.RoleRepository;
import com.rfdev.habittracker.repositories.UserRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Transactional
  public Page<UserDTO> findAllPaged(Pageable pageable) {
    Page<User> list = userRepository.findAll(pageable);
    return list.map(UserDTO::new);
  }

  @Transactional(readOnly = true)
  public UserDTO findById(UUID userId) {
    Optional<User> obj = userRepository.findById(userId);
    User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
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
      throw new ResourceNotFoundException("Id not found " + userId);
    }
  }

  public void delete(UUID userId) {
    try {
      userRepository.deleteById(userId);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException("Id not found " + userId);
    }
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
}
