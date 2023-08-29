package com.todolist.todolistapi.list.mapper;

import com.todolist.todolistapi.list.entity.Photo;
import com.todolist.todolistapi.list.entity.Text;
import com.todolist.todolistapi.list.entity.Todo;
import com.todolist.todolistapi.list.entity.TodoList;
import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.model.TextDto;
import com.todolist.todolistapi.list.model.ToDoListDto;
import com.todolist.todolistapi.list.model.TodoDto;

import java.util.*;
import java.util.stream.Collectors;

public class ToDoListMapper {

    public static ToDoListDto toDto(TodoList todoList){
        ToDoListDto toDoListDTO = new ToDoListDto();
        toDoListDTO.setId(todoList.getId());
        toDoListDTO.getPhotoList().addAll(photoToDtoList(todoList.getPhotoList()));
        toDoListDTO.getTextList().addAll(textToDtoList(todoList.getTextList()));
        toDoListDTO.setTitle(todoList.getTitle());
        toDoListDTO.getTodos().addAll(toDoToDtoList(todoList.getTodos()));
//        toDoListDTO.setUsers(todoList.getUsers());
        return toDoListDTO;
    }

    public static TodoList fromDto(ToDoListDto toDoListDTO, TodoList todoList){
        todoList.setId(toDoListDTO.getId());
        todoList.setTitle(toDoListDTO.getTitle());
        return todoList;
    }

    public static Photo photoFromDto(PhotoDto photoDto, Photo existing){
        Photo photo = existing;
        if (photo.getId() == null) {
            photo = new Photo();
        }
        photo.setPictureURL(photoDto.getPictureURL());
        return photo;
    }

    public static PhotoDto photoToDto(Photo photo) {
        PhotoDto photoDto = new PhotoDto();
        photoDto.setId(photo.getId());
        photoDto.setPictureURL(photo.getPictureURL());
        photoDto.setTodoListId(photo.getTodoList().getId());
        return photoDto;
    }

    public static TextDto textToDto(Text text) {
        TextDto textDto = new TextDto();
        textDto.setId(text.getId());
        textDto.setText(text.getText());
        textDto.setTodoListId(text.getTodoList().getId());
        return textDto;
    }

    public static TodoDto todoToDto(Todo todo){
        TodoDto todoDto =new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setText(todo.getText());
        todoDto.setChecked(todo.isChecked());
        todoDto.setTodoListId(todo.getTodoList().getId());
        return todoDto;
    }

    public static List<PhotoDto> photoToDtoList(List<Photo> photoList){
        return photoList.stream().map(ToDoListMapper::photoToDto).collect(Collectors.toList());
    }

    public static List<TextDto> textToDtoList(List<Text> textList){
        return textList.stream().map(ToDoListMapper::textToDto).collect(Collectors.toList());
    }

    public static List<TodoDto> toDoToDtoList(List<Todo> todoList){
        return todoList.stream().map(ToDoListMapper::todoToDto).collect(Collectors.toList());
    }
}
