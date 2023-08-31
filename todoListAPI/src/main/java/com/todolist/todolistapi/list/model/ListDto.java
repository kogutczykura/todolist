package com.todolist.todolistapi.list.model;



import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListDto {
    private Long id;
    private String title;
    private List<TextDto> textList = new ArrayList<>();
    private List<PhotoDto> photoList = new ArrayList<>();
    private List<TodoDto> todos = new ArrayList<>();
//    private List<User> users;
}
