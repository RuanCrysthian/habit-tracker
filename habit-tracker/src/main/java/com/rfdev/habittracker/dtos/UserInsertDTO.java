package com.rfdev.habittracker.dtos;

import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.services.validations.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO {

  @NotBlank(message = "Password is Mandatory")
  private String password;

  public UserInsertDTO(User user) {
    super(user);
  }
}
