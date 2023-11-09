package com.example.idk.Repositories;

import com.example.idk.Models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    List<Article> findTop6ByOrderByDateDesc();
}
