package com.todolist.todolistapi.list.repo;

import com.todolist.todolistapi.list.entity.Photo;
import com.todolist.todolistapi.list.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<TodoList, Long> {
    @Query("select tl from TodoList tl " +
            "left join fetch tl.photoList " +
            "left join fetch tl.textList " +
            "left join fetch tl.todos " +
            "where tl.id = :idTodolist")
    TodoList getByIdWithRelations(Long idTodolist);
}

