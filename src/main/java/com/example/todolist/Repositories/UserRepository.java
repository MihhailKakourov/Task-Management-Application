package com.example.todolist.Repositories;

import com.example.todolist.Models.Role;
import com.example.todolist.Models.Task;
import com.example.todolist.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findAll();

    User save(User user);
    Optional<User> findById(Long userId);
    List<User> findUserByTask(Task task);
    List<User> findUserByRole(Role role);
    void deleteUserByName(String username);
    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword%")
    List<User> searchByKeyword(@Param("keyword") String keyword);
    void deleteById(Long userId);
}
