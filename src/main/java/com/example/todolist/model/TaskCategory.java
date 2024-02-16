//package com.helloIftekhar.springJpaAuth.model;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "task_categories")
//public class TaskCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long categoryId;
//
//    @Column(nullable = false, length = 50)
//    String categoryName;
//
//    @ManyToMany(mappedBy = "categories")
//    List<Task> tasks;
//}