package com.todolist.todolistapi.list.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private boolean isChecked;
    private String text;
    private Long index;
    private Long todoListId;
}
