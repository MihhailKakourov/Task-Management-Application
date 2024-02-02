package com.example.todolist.Repositories;

import com.example.todolist.Models.User;
import com.example.todolist.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findAll();

    Optional<Task> findById(Long taskId);

    Task save(Task task);
    void deleteById(Long taskId);
    List<Task> findByUser(User user);
    List<Task> findByTaskCategory(String category_name);
    void deleteByUser(User user);
    @Query("SELECT t FROM Task t WHERE t.task_title LIKE %:keyword%")
    List<Task> searchByKeyword(@Param("keyword") String keyword);
}
