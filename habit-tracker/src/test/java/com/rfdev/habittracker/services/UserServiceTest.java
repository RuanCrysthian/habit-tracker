package com.rfdev.habittracker.services;

import com.rfdev.habittracker.dtos.UserDTO;
import com.rfdev.habittracker.dtos.UserInsertDTO;
import com.rfdev.habittracker.factories.user.UserFactory;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.HabitRepository;
import com.rfdev.habittracker.repositories.RoleRepository;
import com.rfdev.habittracker.repositories.UserRepository;
import com.rfdev.habittracker.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private RoleRepository roleRepository;

  @Mock
  private BCryptPasswordEncoder passwordEncoder;

  @Mock
  private HabitRepository habitRepository;

  private UserService userService;

  private UUID existingId;

  private UUID nonExistingId;

  private User user;

  private UserInsertDTO userInsertDTO;

  private PageImpl<User> page;

  @BeforeEach
  void setUp() {
    existingId = UUID.fromString("c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e");
    nonExistingId = UUID.randomUUID();
    user = UserFactory.createUser();
    userInsertDTO = UserFactory.createUserDTO();
    page = new PageImpl<>(List.of(user));
    userService = new UserService(userRepository, roleRepository, passwordEncoder, habitRepository);
  }

  @Test
  void findAllPagedShouldReturnAllUserPageable() {
    // given
    Pageable pageable = PageRequest.of(0, 12);
    when(userRepository.findAll(pageable)).thenReturn(page);

    // when
    Page<UserDTO> result = userService.findAllPaged(pageable);

    // then
    Assertions.assertEquals(page.getTotalElements(), result.getTotalElements());
  }

  @Test
  void insertShouldSaveUserWhenUserDtoIsCorrect() {
    // given
    given(userRepository.save(any(User.class))).willReturn(user);

    //when
    UserDTO result = userService.insert(userInsertDTO);

    //then
    verify(userRepository).save(any(User.class));
    Assertions.assertEquals(user.getUserId(), result.getUserId());
  }

  @Test
  void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
    // given
    when(userRepository.findById(nonExistingId)).thenReturn(Optional.empty());
    // when - then
    Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.findById(nonExistingId));
  }

  @Test
  void findByIdShouldReturnUserDtoWhenIdExists() {
    // given
    when(userRepository.findById(existingId)).thenReturn(Optional.of(user));

    // when
    UserDTO result = userService.findById(existingId);

    // then
    Assertions.assertEquals(user.getUserId(), result.getUserId());
    Assertions.assertEquals(user.getName(), result.getName());
  }

  @Test
  void deleteShouldDoNothingWhenIdExists() {
    // given
    when(userRepository.findById(existingId)).thenReturn(Optional.of(user));

    // when
    userService.delete(existingId);

    // then
    verify(userRepository).delete(user);
  }

  @Test
  void deleteShouldThrowsResourceNotFoundExceptionWhenIdDoesExist() {
    // given
    when(userRepository.findById(nonExistingId)).thenReturn(Optional.empty());

    // when - then
    Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.delete(nonExistingId));
  }
}