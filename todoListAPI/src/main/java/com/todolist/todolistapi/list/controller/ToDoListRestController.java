package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.model.ToDoListDto;
import com.todolist.todolistapi.list.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/todolist")
public class ToDoListRestController {
    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/")
    public ToDoListDto newList(@RequestBody ToDoListDto toDoListDTO){
        return toDoListService.addOrUpdate(toDoListDTO);
    }

    @GetMapping("/{id}")
    public ToDoListDto getTodoList(@PathVariable long id){
        return toDoListService.getOneById(id);
    }

    @DeleteMapping("/{id}")
    public void removeTodoList(@PathVariable long id){
        toDoListService.removeOneById(id);
    }
}
