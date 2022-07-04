package com.example.assignment.service;

import com.example.assignment.entity.BlinkList;
import com.example.assignment.dto.BlinkListDTO;
import java.util.List;
import java.util.Optional;

public interface BlinkListService {

    public List<BlinkListDTO> findAll();

    public Optional<BlinkList> findById(int theId);

    public void save(BlinkList theBlinkList);

    public void deleteById(int theId);

    public List<BlinkList> findByQuery(String author,String category,String status);

}
