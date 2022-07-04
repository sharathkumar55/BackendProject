package com.example.assignment.service;

import com.example.assignment.converter.BlinkListConverter;
import com.example.assignment.dto.BlinkListDTO;
import com.example.assignment.entity.BlinkList;
import com.example.assignment.repository.BlinkListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlinkListServiceImpl implements BlinkListService {


    private BlinkListRepository blinkListRepository;

    @Autowired
    private BlinkListConverter blinkListConverter;

    @Autowired
    public BlinkListServiceImpl(BlinkListRepository theBlinkListRepository){
        blinkListRepository = theBlinkListRepository;
    }

    @Override
    @Transactional
    public List<BlinkListDTO> findAll() {
        List<BlinkList> blinkLists = blinkListRepository.findAll();
        return  blinkListConverter.entityToDto(blinkLists);
    }


    @Override
    @Transactional
    public Optional<BlinkList> findById(int theId) {

        return blinkListRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(BlinkList theBlinkList) {
            blinkListRepository.save(theBlinkList);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        blinkListRepository.deleteById(theId);
    }

    @Override
    public List<BlinkList> findByQuery(String author, String category, String status) {
        List<BlinkList> blinkLists = blinkListRepository.findAll();
        return blinkLists.stream().filter(value->value.getAuthor().contains(author)).filter(value->value.getCategory().contains(category)).filter(value->value.getStatus().contains(status)).collect(Collectors.toList());
    }
        }
