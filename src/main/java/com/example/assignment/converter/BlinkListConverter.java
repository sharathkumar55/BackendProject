package com.example.assignment.converter;

import com.example.assignment.dto.BlinkListDTO;
import com.example.assignment.entity.BlinkList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlinkListConverter {

    public BlinkListDTO entityToDto(BlinkList blinkList){
        BlinkListDTO blinkListDTO = new BlinkListDTO();
        blinkListDTO.setId(blinkList.getId());
        blinkListDTO.setAuthor(blinkList.getAuthor());
        blinkListDTO.setCategory(blinkList.getCategory());
        blinkListDTO.setStatus(blinkList.getStatus());
        blinkListDTO.setTitle(blinkList.getTitle());
        blinkListDTO.setImage(blinkList.getImage());
        return blinkListDTO;
    }

    public BlinkList dtoToEntity(BlinkListDTO blinkListDTO){
        BlinkList blinkList = new BlinkList();
        blinkList.setId(blinkListDTO.getId());
        blinkList.setAuthor(blinkListDTO.getAuthor());
        blinkList.setCategory(blinkListDTO.getCategory());
        blinkList.setStatus(blinkListDTO.getStatus());
        blinkList.setTitle(blinkListDTO.getTitle());
        blinkList.setImage(blinkListDTO.getImage());
        return blinkList;
    }

    public List<BlinkListDTO> entityToDto(List<BlinkList> blinkList)
    {
        return blinkList.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public List<BlinkList> dtoToEntity(List<BlinkListDTO> blinkListDTO)
    {
        return blinkListDTO.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }


}
