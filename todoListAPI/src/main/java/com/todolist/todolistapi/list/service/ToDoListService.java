package com.todolist.todolistapi.list.service;

import com.todolist.todolistapi.list.entity.Photo;
import com.todolist.todolistapi.list.entity.TodoList;
import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.model.ToDoListDto;
import com.todolist.todolistapi.list.repo.ToDoListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.todolist.todolistapi.list.mapper.ToDoListMapper.fromDto;
import static com.todolist.todolistapi.list.mapper.ToDoListMapper.toDto;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

    public ToDoListDto addOrUpdate(ToDoListDto toDoListDTO){
//        Session session = entityManager.unwrap(Session.class);
        TodoList todoList = new TodoList();
        if(toDoListDTO.getId() != null) {
            todoList = toDoListRepository.getReferenceById(toDoListDTO.getId());
        }
        todoList = fromDto(toDoListDTO, todoList);
        todoList = toDoListRepository.save(todoList);

        return toDto(todoList);
    }

    public ToDoListDto getOneById(long id){
        return toDto(toDoListRepository.getReferenceById(id));
    }

    public void removeOneById(long id){
        toDoListRepository.deleteById(id);
    }

    public PhotoDto add
}
