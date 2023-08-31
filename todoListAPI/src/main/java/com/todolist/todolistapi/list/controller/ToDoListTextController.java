package com.todolist.todolistapi.list.controller;

import com.todolist.todolistapi.list.model.TextDto;
import com.todolist.todolistapi.list.model.TextListDto;
import com.todolist.todolistapi.list.service.TextListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/todolist/text")
public class ToDoListTextController {

    @Autowired
    private TextListService textListService;

    @PostMapping("")
    public List<TextDto> createOrUpdate(@RequestBody TextListDto textDtoList){
        return textListService.createOrUpdate(textDtoList);
    }
}
