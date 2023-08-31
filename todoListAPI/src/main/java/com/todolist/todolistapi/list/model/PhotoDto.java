package com.todolist.todolistapi.list.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto{
    private Long id;
    private String pictureURL;
    private Long index;
    private Long todoListId;

}
