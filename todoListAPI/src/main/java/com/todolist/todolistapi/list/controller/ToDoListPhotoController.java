package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.model.PhotoListDto;
import com.todolist.todolistapi.list.service.PhotoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/todolist/photo")
public class ToDoListPhotoController {
    @Autowired
    private PhotoListService photoListService;

    @PostMapping("")
    public List<PhotoDto> addOrUpdatePhoto(@RequestBody PhotoListDto photoDtoList){
        return photoListService.addOrUpdate(photoDtoList);
    }

}
