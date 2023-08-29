package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.entity.Photo;
import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/todolist/photo")
public class ToDoListPhotoController {
    @Autowired
    private ToDoListService toDoListService;

    @PostMapping
    public PhotoDto addOrUpdatePhoto(PhotoDto photoDto){
        toDoListService.
    }

}
