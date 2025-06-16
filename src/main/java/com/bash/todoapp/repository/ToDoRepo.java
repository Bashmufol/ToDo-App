package com.bash.todoapp.repository;

import com.bash.todoapp.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<TodoEntity, Long> {
}
