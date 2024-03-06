package com.rfdev.habittracker.dtos;

import com.rfdev.habittracker.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO extends UserDTO {

  @NotBlank(message = "Password is Mandatory")
  private String password;
}
