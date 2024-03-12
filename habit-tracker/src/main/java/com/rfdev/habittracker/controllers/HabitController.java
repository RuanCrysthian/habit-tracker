package com.rfdev.habittracker.controllers;

import com.rfdev.habittracker.dtos.HabitDTO;
import com.rfdev.habittracker.services.HabitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/habits")
public class HabitController {

  @Autowired
  private HabitService habitService;

  @GetMapping
  public ResponseEntity<Page<HabitDTO>> findAll(Pageable pageable) {
    return ResponseEntity.ok().body(habitService.findAllPaged(pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<HabitDTO> findById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(habitService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<HabitDTO> update(@PathVariable UUID id, @Valid @RequestBody HabitDTO dto) {
    HabitDTO newDto = habitService.update(id, dto);
    return ResponseEntity.ok().body(newDto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<HabitDTO> delete(@PathVariable UUID id) {
    habitService.deleteHabit(id);
    return ResponseEntity.noContent().build();
  }
}
