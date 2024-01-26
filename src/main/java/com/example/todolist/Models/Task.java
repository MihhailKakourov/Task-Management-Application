package com.example.todolist.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(nullable = false, length = 50)
    private String task_title;

    @Column(length = 1000)
    private String task_description;

    private Date deadline;

    @Column(nullable = false, length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Task tasks;
}