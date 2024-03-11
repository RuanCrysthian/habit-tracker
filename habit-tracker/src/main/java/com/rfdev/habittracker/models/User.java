package com.rfdev.habittracker.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  @Column(name = "user_id")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID userId;

  @Column(name = "name")
  private String name;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "tb_user_role",
    joinColumns = @JoinColumn(
      name = "user_id"
    ),
    inverseJoinColumns = @JoinColumn(
      name = "role_id"
    )
  )
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Habit> habits = new HashSet<>();
}
