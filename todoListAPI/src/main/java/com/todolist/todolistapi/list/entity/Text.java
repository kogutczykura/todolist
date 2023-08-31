package com.todolist.todolistapi.list.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long index;
    @ManyToOne
    private ListEntity listEntity;
}
