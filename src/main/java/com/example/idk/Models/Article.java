package com.example.idk.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long articleId;
    private String title;
    private String articleCover;
    private LocalDate date;


    public Article(String title, String articleCover, LocalDate date, Set<Content> content) {
        this.title = title;
        this.articleCover = articleCover;
        this.date = date;
        this.content = content;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="article_content",
            joinColumns = {@JoinColumn(name="articleId")},
            inverseJoinColumns = {@JoinColumn(name="contentId")}
    )


    private Set<Content> content;
}
