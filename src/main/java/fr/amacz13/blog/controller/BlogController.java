package fr.amacz13.blog.controller;

import fr.amacz13.blog.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String greeting(Model model) {
        model.addAttribute("allArticles", articleRepository.findAll());
        return "blog";
    }
}
