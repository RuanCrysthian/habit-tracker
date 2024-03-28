package com.rfdev.habittracker.factories.user;

import com.rfdev.habittracker.dtos.UserInsertDTO;
import com.rfdev.habittracker.models.Role;
import com.rfdev.habittracker.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class UserFactory {

  private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public static User createUser() {
    User user = new User();
    user.setUserId(UUID.fromString("c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e"));
    user.setName("test");
    user.setUsername("test_test");
    user.setPassword(passwordEncoder.encode("test"));
    user.setEmail("test@test.com");
    user.getRoles().add(new Role(UUID.randomUUID(), "ROLE_ADMIN"));
    return user;
  }

  public static UserInsertDTO createUserDTO() {
    User user = createUser();
    return new UserInsertDTO(user);
  }
}
