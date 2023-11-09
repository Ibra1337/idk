package com.example.idk.adiitionalResources.developmentTools;

import com.example.idk.Models.Article;
import com.example.idk.Models.Content;
import com.example.idk.Repositories.ArticleRepo;
import com.example.idk.Repositories.ContentRepo;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;

public class ArticleGenerator {


    Faker faker;
    ContentRepo contentRepo;
    ArticleRepo articleRepo;

    public ArticleGenerator(Faker faker, ContentRepo contentRepo , ArticleRepo articleRepo) {
        this.faker=faker;
        this.contentRepo=contentRepo;
        this.articleRepo = articleRepo;
    }


    public Set<Content> generateContentSet(int n)
    {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n";
        HashSet<Content> contents = new HashSet<>();
        for (int i =0 ; i < n ; i++)
        {
            contents.add(new Content(faker.lorem().paragraph()));
        }
        return contents;
    }


    // TODO: 05.11.2023 maybe optymalize it in order to not to save each time but save alll article contents and then add them to article
    public Set<Article> generateArticle(int articleAmount , int numOfParagraphs)
    {
        Set<Article> res = new HashSet<>();
        for (int i = 0; i < articleAmount; i++) {

            Set<Content> tmp = generateContentSet(numOfParagraphs);
            contentRepo.saveAll(tmp);
            res.add(new Article(faker.leagueOfLegends().location(),"logo.png" , LocalDate.now() ,tmp ));

        }
        articleRepo.saveAll(res);
        return res;
    }

}
