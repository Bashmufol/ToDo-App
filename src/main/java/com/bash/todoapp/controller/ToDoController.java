package com.bash.todoapp.controller;

import com.bash.todoapp.repository.ToDoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoRepo toDoRepo;

    @GetMapping({"","/","/home"})
    public String homePage(Model model) {
        model.addAttribute("todos", toDoRepo.findAll());
        return "index";
    }
}
