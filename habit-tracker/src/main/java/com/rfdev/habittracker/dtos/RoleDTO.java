package com.rfdev.habittracker.dtos;

import com.rfdev.habittracker.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO implements Serializable {

  private UUID roleId;

  private String authority;

  public RoleDTO(Role role) {
    roleId = role.getRoleId();
    authority = role.getAuthority();
  }

}
