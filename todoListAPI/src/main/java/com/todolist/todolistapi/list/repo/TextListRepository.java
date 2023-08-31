package com.todolist.todolistapi.list.repo;

import com.todolist.todolistapi.list.entity.Text;
import com.todolist.todolistapi.list.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TextListRepository extends JpaRepository<Text, Long> {
    //List<Text> getAllByTodoList(ListEntity todoListEntity);
}
