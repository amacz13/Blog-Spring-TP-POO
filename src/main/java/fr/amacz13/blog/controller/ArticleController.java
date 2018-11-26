package fr.amacz13.blog.controller;

import fr.amacz13.blog.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/article")
    public String greeting(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        model.addAttribute("article", articleRepository.findById(id).get());
        return "article";
    }


}
