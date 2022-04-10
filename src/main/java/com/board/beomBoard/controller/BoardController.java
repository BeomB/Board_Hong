package com.board.beomBoard.controller;

import com.board.beomBoard.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("name","이범기");
        return "home";
    }




}
