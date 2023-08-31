package com.todolist.todolistapi.list.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isChecked;
    private String text;
    private Long index;
    @ManyToOne
    private ListEntity listEntity;
}
