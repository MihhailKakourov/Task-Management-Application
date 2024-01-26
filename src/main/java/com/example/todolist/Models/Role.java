package com.example.todolist.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(nullable = false, length = 20)
    private String role_name;

    @OneToMany(mappedBy = "roles")
    private List<User> users;
}
