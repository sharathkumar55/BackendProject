package com.example.assignment.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BlinkListErrorResponse {

    private int status;

    private String message;

    private long timeStamp;
}
