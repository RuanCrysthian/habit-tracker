package com.rfdev.habittracker.controllers;

import com.rfdev.habittracker.dtos.HabitRecordRequestDTO;
import com.rfdev.habittracker.dtos.HabitRecordResponseDTO;
import com.rfdev.habittracker.services.HabitRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/habit-records")
public class HabitRecordController {

  @Autowired
  private HabitRecordService habitRecordService;

  @GetMapping
  public ResponseEntity<Page<HabitRecordResponseDTO>> findAll(Pageable pageable) {
    return ResponseEntity.ok().body(habitRecordService.findAll(pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<HabitRecordResponseDTO> findById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(habitRecordService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<HabitRecordResponseDTO> update(@PathVariable UUID id,
                                                       @Valid @RequestBody HabitRecordRequestDTO dto) {
    HabitRecordResponseDTO newDTO = habitRecordService.update(id, dto);
    return ResponseEntity.ok().body(newDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<HabitRecordResponseDTO> delete(@PathVariable UUID id) {
    habitRecordService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

