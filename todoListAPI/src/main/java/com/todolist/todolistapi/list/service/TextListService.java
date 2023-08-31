package com.todolist.todolistapi.list.service;

import com.todolist.todolistapi.list.mapper.ListMapper;
import com.todolist.todolistapi.list.model.TextDto;
import com.todolist.todolistapi.list.model.TextListDto;
import com.todolist.todolistapi.list.repo.TextListRepository;
import com.todolist.todolistapi.list.repo.ListRepository;
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
public class TextListService {
    @Autowired
    private ListMapper listMapper;

    @Autowired
    private TextListRepository textListRepository;

    @Autowired
    private ListRepository listRepository;


    public List<TextDto> createOrUpdate(TextListDto textDtoList){
        textListRepository.saveAll(listMapper.textListFromDto(textDtoList.getTextDtoList()));
        return listMapper.textToDtoList(listRepository.getReferenceById(textDtoList.getTextDtoList().get(0).getTodoListId()).getTextList());
    }
}
