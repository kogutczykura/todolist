package com.todolist.todolistapi.list.repo;

import com.todolist.todolistapi.list.entity.ListEntity;
import com.todolist.todolistapi.list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TodoListRepository extends JpaRepository<Todo, Long> {
    //List<Todo> findAllByTodoListEntity(ListEntity todoListEntityId);
}
