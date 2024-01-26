package com.example.todolist.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_categories")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(nullable = false, length = 50)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TaskCategory task_category;
}