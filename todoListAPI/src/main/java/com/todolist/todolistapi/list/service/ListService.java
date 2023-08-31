package com.todolist.todolistapi.list.service;

import com.todolist.todolistapi.list.entity.ListEntity;
import com.todolist.todolistapi.list.mapper.ListMapper;
import com.todolist.todolistapi.list.model.ListDto;
import com.todolist.todolistapi.list.repo.ListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ListService {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ListMapper listMapper;

//    @PersistenceContext
//    private EntityManager entityManager;

    public ListDto addOrUpdate(ListDto toDoListDTO){
//        Session session = entityManager.unwrap(Session.class);
        ListEntity todoListEntity = new ListEntity();
        if(toDoListDTO.getId() != null) {
            todoListEntity = listRepository.getReferenceById(toDoListDTO.getId());
        }
        todoListEntity = listMapper.fromDto(toDoListDTO, todoListEntity);
        todoListEntity = listRepository.save(todoListEntity);

        return listMapper.toDto(todoListEntity);
    }

    public ListDto getOneById(long id){
        return listMapper.toDto(listRepository.getReferenceById(id));
    }

    public void removeOneById(long id){
        listRepository.deleteById(id);
    }

}
