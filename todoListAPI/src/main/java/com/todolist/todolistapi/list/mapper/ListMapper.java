package com.todolist.todolistapi.list.mapper;

import com.todolist.todolistapi.list.entity.Photo;
import com.todolist.todolistapi.list.entity.Text;
import com.todolist.todolistapi.list.entity.Todo;
import com.todolist.todolistapi.list.entity.ListEntity;
import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.model.TextDto;
import com.todolist.todolistapi.list.model.ListDto;
import com.todolist.todolistapi.list.model.TodoDto;
import com.todolist.todolistapi.list.repo.PhotoListRepository;
import com.todolist.todolistapi.list.repo.TextListRepository;
import com.todolist.todolistapi.list.repo.ListRepository;
import com.todolist.todolistapi.list.repo.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
@Component
public class ListMapper {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private PhotoListRepository photoListRepository;

    @Autowired
    private TextListRepository textListRepository;

    @Autowired
    private TodoListRepository todoListRepository;

    public ListDto toDto(ListEntity todoListEntity){
        ListDto listDto = new ListDto();
        listDto.setId(todoListEntity.getId());
        listDto.getPhotoList().addAll(photoToDtoList(todoListEntity.getPhotoList()));
        listDto.getTextList().addAll(textToDtoList(todoListEntity.getTextList()));
        listDto.setTitle(todoListEntity.getTitle());
        listDto.getTodos().addAll(toDoToDtoList(todoListEntity.getTodos()));
//        listDto.setUsers(todoList.getUsers());
        return listDto;
    }

    public ListEntity fromDto(ListDto listDto, ListEntity todoListEntity){
        if(todoListEntity.getId()==null){
            todoListEntity = new ListEntity();
        }
        todoListEntity.setId(listDto.getId());
        todoListEntity.setTitle(listDto.getTitle());
        return todoListEntity;
    }

    public PhotoDto photoToDto(Photo photo) {
        PhotoDto photoDto = new PhotoDto();
        photoDto.setId(photo.getId());
        photoDto.setPictureURL(photo.getPictureURL());
        photoDto.setIndex(photo.getIndex());
        photoDto.setTodoListId(photo.getListEntity().getId());
        return photoDto;
    }

    public TextDto textToDto(Text text) {
        TextDto textDto = new TextDto();
        textDto.setId(text.getId());
        textDto.setText(text.getText());
        textDto.setIndex(text.getIndex());
        textDto.setTodoListId(text.getListEntity().getId());
        return textDto;
    }

    public TodoDto todoToDto(Todo todo){
        TodoDto todoDto =new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setText(todo.getText());
        todoDto.setChecked(todo.isChecked());
        todoDto.setIndex(todo.getIndex());
        todoDto.setTodoListId(todo.getListEntity().getId());
        return todoDto;
    }

    public List<PhotoDto> photoToDtoList(List<Photo> photoList){
        return photoList.stream().map(this::photoToDto).collect(Collectors.toList());
    }

    public List<TextDto> textToDtoList(List<Text> textList){
        return textList.stream().map(this::textToDto).collect(Collectors.toList());
    }

    public List<TodoDto> toDoToDtoList(List<Todo> todoList){
        return todoList.stream().map(this::todoToDto).collect(Collectors.toList());
    }

    public Photo photoFromDto(PhotoDto photoDto){
        Photo photo = new Photo();
        if (photoDto.getId() != null) {
            photo = photoListRepository.getReferenceById(photo.getId());
        } else {
            photo.setListEntity(listRepository.getReferenceById(photoDto.getTodoListId()));
        }
        photo.setPictureURL(photoDto.getPictureURL());
        photo.setIndex(photoDto.getIndex());
        return photo;
    }

    public Text textFromDto(TextDto textDto){
        Text text = new Text();
        if(textDto.getId() != null) {
            text = textListRepository.getReferenceById(text.getId());
        } else {
            text.setListEntity(listRepository.getReferenceById(textDto.getTodoListId()));
        }

        text.setText(textDto.getText());
        text.setIndex(textDto.getIndex());
        return text;
    }

    public Todo todoFromDto(TodoDto todoDto){
        Todo todo = new Todo();
        if(todoDto.getId() != null){
            todo = todoListRepository.getReferenceById(todo.getId());
        } else {
            todo.setListEntity(listRepository.getReferenceById(todoDto.getTodoListId()));
        }
        todo.setText(todoDto.getText());
        todo.setChecked(todoDto.isChecked());
        todo.setIndex(todoDto.getIndex());
        return todo;
    }

    public List<Text> textListFromDto(List<TextDto> textDtoList){
        return textDtoList
                .stream()
                .map(textDto -> textFromDto(textDto))
                .collect(Collectors.toList());
    }

    public List<Todo> todoListFromDto(List<TodoDto> todoDtoList){
        return todoDtoList
                .stream()
                .map(todoDto -> todoFromDto(todoDto))
                .collect(Collectors.toList());
    }

    public List<Photo> photoListFromDto(List<PhotoDto> photoDtoList){
        return photoDtoList
                .stream()
                .map(photoDto -> photoFromDto(photoDto))
                .collect(Collectors.toList());
    }


}
