package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlinkListDTO {

    private int id;

    private String title;

    private String author;

    private String category;

    private String status;

    private String image;


}
