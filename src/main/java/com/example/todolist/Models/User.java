package com.example.todolist.Models;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roles;

    @OneToMany(mappedBy = "users")
    private List<Task> tasks;

    @OneToMany(mappedBy = "users")
    private List<TaskCategory> categories;
}
