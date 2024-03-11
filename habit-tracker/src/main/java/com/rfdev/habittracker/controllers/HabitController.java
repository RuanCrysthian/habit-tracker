package com.rfdev.habittracker.controllers;

import com.rfdev.habittracker.dtos.HabitDTO;
import com.rfdev.habittracker.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
