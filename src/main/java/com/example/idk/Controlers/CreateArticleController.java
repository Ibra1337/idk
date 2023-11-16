package com.example.idk.Controlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createController")
public class CreateArticleController {


    @GetMapping
    public String createArticle()
    {
        return "createArticle";
    }
}
