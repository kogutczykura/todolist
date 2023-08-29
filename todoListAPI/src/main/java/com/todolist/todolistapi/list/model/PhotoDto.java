package com.todolist.todolistapi.list.model;

import com.todolist.todolistapi.list.entity.TodoList;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    private Long id;
    private String pictureURL;
    private Long todoListId;
}
