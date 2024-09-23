package com.example.sbb1.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private  String content;

    private LocalDateTime createDate;
}
