package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.model.ListDto;
import com.todolist.todolistapi.list.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/todolist")
public class ToDoListRestController {
    @Autowired
    private ListService listService;

    @PostMapping("/")
    public ListDto newList(@RequestBody ListDto toDoListDTO){
        return listService.addOrUpdate(toDoListDTO);
    }

    @GetMapping("/{id}")
    public ListDto getTodoList(@PathVariable long id){
        return listService.getOneById(id);
    }

    @DeleteMapping("/{id}")
    public void removeTodoList(@PathVariable long id){
        listService.removeOneById(id);
    }
}
