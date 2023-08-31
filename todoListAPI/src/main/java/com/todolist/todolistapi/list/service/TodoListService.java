package com.todolist.todolistapi.list.service;

import com.todolist.todolistapi.list.mapper.ListMapper;
import com.todolist.todolistapi.list.model.TodoDto;
import com.todolist.todolistapi.list.model.TodoListDto;
import com.todolist.todolistapi.list.repo.ListRepository;
import com.todolist.todolistapi.list.repo.TodoListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private ListMapper listMapper;

    @Autowired
    private ListRepository listRepository;

    public List<TodoDto> createOrUpdate(TodoListDto todoListDto){
        todoListRepository.saveAll(listMapper.todoListFromDto(todoListDto.getTodoDtoList()));
        return listMapper.toDoToDtoList(listRepository.getReferenceById(todoListDto.getTodoDtoList().get(0).getTodoListId()).getTodos());
    }
}
