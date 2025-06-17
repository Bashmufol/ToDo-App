package com.bash.todoapp.controller;

import com.bash.todoapp.model.TodoEntity;
import com.bash.todoapp.repository.ToDoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoRepo toDoRepo;

    @GetMapping({"","/","/home"})
    public String homePage(Model model) {
        model.addAttribute("todos", toDoRepo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        TodoEntity newTodo = TodoEntity.builder()
                .title(title)
                .Completed(false)
                .build();
        toDoRepo.save(newTodo);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        TodoEntity existingTodo = toDoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found: "+id));
        existingTodo.setCompleted(true);
        toDoRepo.save(existingTodo);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        TodoEntity existingTodo = toDoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found: "+id));
        toDoRepo.delete(existingTodo);
        return "redirect:/home";
    }
}
