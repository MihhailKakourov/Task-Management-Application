package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taskId;

    @Column(nullable = false, length = 50)
    String taskTitle;

    @Column(length = 1000)
    String taskDescription;

    @ManyToOne
    @JoinColumn(name = "userId")
    User users;

//    @ManyToMany
//    @JoinTable(name = "taskAndCategory",
//               joinColumns = @JoinColumn(name = "taskId"),
//               inverseJoinColumns = @JoinColumn(name = "categoryId"))
//    List<TaskCategory> categories;


}