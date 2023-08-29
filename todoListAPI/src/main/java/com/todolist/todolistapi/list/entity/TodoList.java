package com.todolist.todolistapi.list.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    private List<Text> textList = new ArrayList<>();

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    private List<Photo> photoList = new ArrayList<>();

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    private List<Todo> todos = new ArrayList<>();

    //    @ManyToMany(mappedBy = "todoLists", cascade = CascadeType.ALL)
    //    private List<User> users = new ArrayList<>();
}
