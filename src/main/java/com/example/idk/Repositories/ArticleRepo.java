package com.example.idk.Repositories;

import com.example.idk.Models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Long> {

}
