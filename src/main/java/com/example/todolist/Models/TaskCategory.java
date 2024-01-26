package com.example.todolist.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "task_categories")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(nullable = false, length = 50)
    private String category_name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
}