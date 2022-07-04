package com.example.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="blinklist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlinkList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="category")
    private String category;

    @Column(name="status")
    private String status;

    @Column(name="image")
    private String image;


}
