package com.rfdev.habittracker.controllers;

import com.rfdev.habittracker.dtos.HabitDTO;
import com.rfdev.habittracker.dtos.UserDTO;
import com.rfdev.habittracker.dtos.UserInsertDTO;
import com.rfdev.habittracker.dtos.UserUpdateDTO;
import com.rfdev.habittracker.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
    Page<UserDTO> list = userService.findAllPaged(pageable);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
    UserDTO dto = userService.findById(id);
    return ResponseEntity.ok().body(dto);
  }

  @PostMapping
  public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
    UserDTO newDto = userService.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
      buildAndExpand(newDto.getUserId()).toUri();
    return ResponseEntity.created(uri).body(newDto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserDTO> update(@PathVariable UUID id, @Valid @RequestBody UserUpdateDTO dto) {
    UserDTO newDTO = userService.update(id, dto);
    return ResponseEntity.ok().body(newDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<UserDTO> delete(@PathVariable UUID id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(value = "/{userId}/habits")
  public ResponseEntity<HabitDTO> insertHabit(@PathVariable UUID userId,
                                              @Valid @RequestBody HabitDTO habitDTO) {
    HabitDTO newDto = userService.insertHabit(userId, habitDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}/habits")
      .buildAndExpand(newDto.getHabitId()).toUri();
    return ResponseEntity.created(uri).body(newDto);
  }

  @GetMapping(value = "/{userId}/habits")
  public ResponseEntity<Page<HabitDTO>> findAllHabitsFromUserId(@PathVariable UUID userId,
                                                                Pageable pageable) {
    return ResponseEntity.ok().body(userService.findAllHabitsByUserId(userId, pageable));
  }
}
