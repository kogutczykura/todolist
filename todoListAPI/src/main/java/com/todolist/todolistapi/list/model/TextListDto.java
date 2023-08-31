package com.todolist.todolistapi.list.model;

import com.todolist.todolistapi.list.entity.Text;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextListDto {
    private List<TextDto> textDtoList = new ArrayList<>();
}
