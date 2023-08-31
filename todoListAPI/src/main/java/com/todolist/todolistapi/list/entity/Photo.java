package com.todolist.todolistapi.list.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pictureURL;
    private Long index;
    @ManyToOne
    private ListEntity listEntity;
}
