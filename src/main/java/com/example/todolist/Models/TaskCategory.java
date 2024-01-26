package com.example.todolist.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "task_categories")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;

    @Column(nullable = false, length = 50)
    String categoryName;

    @ManyToOne
    @JoinColumn(name = "taskId")
    Task tasks;
}