package com.example.todolist.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(nullable = false, length = 100)
    String username;

    @Column(nullable = false, length = 200)
    String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    Role roles;

    @OneToMany(mappedBy = "users")
    List<Task> tasks;
}
