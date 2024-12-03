package com.TaskManagement.ToDoApp.service;

import com.TaskManagement.ToDoApp.entity.ToDoEntity;
import com.TaskManagement.ToDoApp.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Component
public class ToDoService {
        @Autowired
        private ToDoRepo todoRepository;
        public List<ToDoEntity> getAllTodos() {
            return todoRepository.findAll();
        }
        public Optional<ToDoEntity> getTodoById(Long id) {
            return todoRepository.findById(id);
        }
        public ToDoEntity createTodo(ToDoEntity todo) {
            return todoRepository.save(todo);
        }
        public ToDoEntity updateTodo(Long id, ToDoEntity updatedTodo) {
            return todoRepository.findById(id)
                    .map(todo -> {
                        todo.setTitle(updatedTodo.getTitle());
                        todo.setDescription(updatedTodo.getDescription());
                        todo.setCompleted(updatedTodo.isCompleted());
                        return todoRepository.save(todo);
                    })
                    .orElseThrow(() -> new RuntimeException("Todo not found"));
        }
        public void deleteTodoById(Long id) {
            todoRepository.deleteById(id);
        }
    }
