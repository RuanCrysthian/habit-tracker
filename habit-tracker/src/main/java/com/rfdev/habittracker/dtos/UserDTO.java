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
public class UserDTO implements Serializable {

  private UUID userId;

  @NotBlank(message = "Name is Mandatory")
  private String name;

  @NotBlank(message = "Username is Mandatory")
  private String username;

  @Email(message = "Email Invalid")
  @NotBlank(message = "Email is Mandatory")
  private String email;

  private Set<RoleDTO> roles = new HashSet<>();

  public UserDTO(User user) {
    this.userId = user.getUserId();
    this.name = user.getName();
    this.username = user.getUsername();
    this.email = user.getEmail();
    user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
  }
}
