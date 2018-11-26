package fr.amacz13.blog.controller;

import fr.amacz13.blog.model.Article;
import fr.amacz13.blog.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Random;

@Controller
public class AddArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/add-article")
    public String greeting(Model model) {
        model.addAttribute("article", new Article());
        return "add-article";
    }

    @PostMapping("/addArticle")
    public String greetingSubmit(@ModelAttribute Article article) {
        article.setId(""+articleRepository.count()+1);
        article.setCreation(new Date());
        System.out.println(article);
        articleRepository.save(article);
        return "success";
    }
}