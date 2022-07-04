package com.example.assignment.rest;

import com.example.assignment.converter.BlinkListConverter;
import com.example.assignment.dto.BlinkListDTO;
import com.example.assignment.entity.BlinkList;
import com.example.assignment.repository.BlinkListRepository;
import com.example.assignment.service.BlinkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlinkListRestController {

    private BlinkListService blinkListService;

    @Autowired
    private BlinkListConverter blinkListConverter;

    @Autowired
    private BlinkListRepository blinkListRepository;

    @Autowired
    public BlinkListRestController(BlinkListService theBlinkListService)
    {
        blinkListService = theBlinkListService;
    }

    @GetMapping("/blinks/{blinkId}")
    public Optional<BlinkList> getBlinkList(@PathVariable int blinkId){
        List<BlinkListDTO> blinkLists = blinkListService.findAll();
        Optional<BlinkList> blinkList = blinkListService.findById(blinkId);
        if((blinkId<0) || (blinkId>blinkLists.size()))
        {
            throw new BlinkListNotFoundException("Blink is Not Found with ID :"+blinkId);
        }
        return blinkList;

    }

    //save
    @PostMapping("/blinks")
    public BlinkList addBlinkList(@RequestBody BlinkListDTO theBlinkListDto)
    {
        //also just in case they pass an id in JSON set id to 0//this is to force a save of new item ... instead of update
        theBlinkListDto.setId(0);
        BlinkList blinkList = blinkListConverter.dtoToEntity(theBlinkListDto);
        blinkListService.save(blinkList);
        return blinkList;
    }

    @PutMapping("/blinks")
    public BlinkList updateBlinkList(@RequestBody BlinkListDTO theBlinkListDto){
        BlinkList blinkList = blinkListConverter.dtoToEntity(theBlinkListDto);
        blinkListService.save(blinkList);
        return blinkList;
    }

    @DeleteMapping("/blinks/{blinkId}")
    public  void deleteBlinkList(@PathVariable int blinkId){
        blinkListService.deleteById(blinkId);
    }

    @GetMapping("/blinks")
    public List<BlinkList> findByAuthorAndBookCategory(@RequestParam(value = "author",required = false,defaultValue = "") String author,@RequestParam(value = "category",required = false,defaultValue = "") String category,@RequestParam(value = "status",required = false,defaultValue = "") String status)
    {
        return blinkListService.findByQuery(author,category,status);
    }



}
