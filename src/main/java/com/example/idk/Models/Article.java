package com.example.idk.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Article {

    @Id
    private Long articleId;
    private String title;
    private String articleCover;
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="article_content",
            joinColumns = {@JoinColumn(name="articleId")},
            inverseJoinColumns = {@JoinColumn(name="contentId")}
    )


    private Set<Content> content;
}
