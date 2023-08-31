package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.model.TodoDto;
import com.todolist.todolistapi.list.model.TodoListDto;
import com.todolist.todolistapi.list.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/todolist/todo")
public class ToDoListTodoController {
    @Autowired
    private TodoListService todoListService;

    @PostMapping("")
    public List<TodoDto> createOrUodate(@RequestBody TodoListDto todoListDto){
        return todoListService.createOrUpdate(todoListDto);
    }
}
