package com.TaskManagement.ToDoApp.toDoController;

import com.TaskManagement.ToDoApp.entity.ToDoEntity;
import com.TaskManagement.ToDoApp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/todos")
public class ToDoController {
        @Autowired
        private ToDoService todoService;

        @GetMapping
        public List<ToDoEntity> getAllTodos() {
            return todoService.getAllTodos();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ToDoEntity> getTodoById(@PathVariable Long id) {
            Optional<ToDoEntity> todo = todoService.getTodoById(id);
            return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<ToDoEntity> createTodo(@RequestBody ToDoEntity todo) {
            ToDoEntity createdTodo = todoService.createTodo(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ToDoEntity> updateTodo(@PathVariable Long id, @RequestBody ToDoEntity updatedTodo) {
            ToDoEntity todo = todoService.updateTodo(id, updatedTodo);
            return ResponseEntity.ok(todo);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
            todoService.deleteTodoById(id);
            return ResponseEntity.noContent().build();
        }
    }

