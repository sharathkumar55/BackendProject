package com.example.assignment.dao;

import com.example.assignment.entity.BlinkList;

import java.util.List;

public interface BlinkListDAO {
    public List<BlinkList> findAll();

    public BlinkList findById(int theId);

    public void save(BlinkList theBlinkList);

    public void deleteById(int theId);
}