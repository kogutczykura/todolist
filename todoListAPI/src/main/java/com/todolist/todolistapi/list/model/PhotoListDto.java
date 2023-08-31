package com.todolist.todolistapi.list.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoListDto {
    private List<PhotoDto> photoDtoList = new ArrayList<>();
}
