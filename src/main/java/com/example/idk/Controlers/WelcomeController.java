package com.example.idk.Controlers;

import com.example.idk.Models.Article;
import com.example.idk.Models.Content;
import com.example.idk.Repositories.ArticleRepo;
import com.example.idk.Repositories.ContentRepo;
import com.example.idk.adiitionalResources.developmentTools.ArticleGenerator;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
@Component
@Slf4j
public class WelcomeController implements ApplicationListener<ContextRefreshedEvent> {


    ArticleRepo articleRepo;
    ContentRepo contentRepo;

    public WelcomeController(ArticleRepo articleRepo, ContentRepo contentRepo) {
        this.articleRepo = articleRepo;
        this.contentRepo = contentRepo;
    }

    @GetMapping("/")
    public String greetings(Model model){
        Sort sort = Sort.by(Sort.Direction.DESC, "timestamp"); // Sort by timestamp in descending order

        List<Article> articles = articleRepo.findTop6ByOrderByDateDesc();
        log.info(String.valueOf(articles.size()));
        model.addAttribute("articles" , articles);
        return "index";
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("STARTED FINALLY");
        if (!articleRepo.existsById(1l)) {
            init();
        }
    }

    public void init()
    {
        Faker faker = new Faker();
        ArticleGenerator articleGenerator = new ArticleGenerator(faker , contentRepo , articleRepo);
        articleGenerator.generateArticle(7 , 10);

    }



}

