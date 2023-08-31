package com.todolist.todolistapi.list.repo;

import com.todolist.todolistapi.list.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoListRepository extends JpaRepository<Photo, Long> {

}
