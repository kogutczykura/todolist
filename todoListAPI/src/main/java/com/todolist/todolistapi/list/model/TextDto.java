package com.todolist.todolistapi.list.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextDto {
    private Long id;
    private String text;
    private Long index;
    private Long todoListId;
}
