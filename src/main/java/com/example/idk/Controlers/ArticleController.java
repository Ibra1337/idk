package com.example.idk.Controlers;


import com.example.idk.Repositories.ArticleRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleRepo articleRepo;

    public ArticleController(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }


    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id , Model model) {
        var optArticle = articleRepo.findById(id);
        if (optArticle.isEmpty())
        {
            return "redirect:/";
        }
        model.addAttribute("article" , optArticle.get());
        return "article";
    }
}