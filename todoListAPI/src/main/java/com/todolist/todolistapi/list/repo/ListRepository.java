package com.todolist.todolistapi.list.repo;

import com.todolist.todolistapi.list.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {
//    @Query("select tl from ListEntity tl " +
//            "left join fetch tl.photoList " +
//            "left join fetch tl.textList " +
//            "left join fetch tl.todos " +
//            "where tl.id = :idTodolist")
//    ListEntity getByIdWithRelations(Long idTodolist);

}

