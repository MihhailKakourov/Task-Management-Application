package com.example.todolist.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long roleId;

    @Column(nullable = false, length = 20)
    String roleName;

    @OneToMany(mappedBy = "roles")
    List<User> users;
}
