package com.todolist.todolistapi.list.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoListDto {
    private List<TodoDto> todoDtoList = new ArrayList<>();
}
