package com.TaskManagement.ToDoApp.repository;

import com.TaskManagement.ToDoApp.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoEntity, Long> {
    // Additional methods for querying and manipulating ToDoEntity data
}

