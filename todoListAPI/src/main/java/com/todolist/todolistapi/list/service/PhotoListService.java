package com.todolist.todolistapi.list.service;

import com.todolist.todolistapi.list.mapper.ListMapper;
import com.todolist.todolistapi.list.model.PhotoDto;
import com.todolist.todolistapi.list.model.PhotoListDto;
import com.todolist.todolistapi.list.repo.ListRepository;
import com.todolist.todolistapi.list.repo.PhotoListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class PhotoListService {
    @Autowired
    private PhotoListRepository photoListRepository;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ListMapper listMapper;

    public List<PhotoDto> addOrUpdate(PhotoListDto photoDtoList){
        photoListRepository.saveAll(listMapper.photoListFromDto(photoDtoList.getPhotoDtoList()));
        return listMapper.photoToDtoList(listRepository.getReferenceById(photoDtoList.getPhotoDtoList().get(0).getTodoListId()).getPhotoList());
    }
}
