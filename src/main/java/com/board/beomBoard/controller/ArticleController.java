package com.board.beomBoard.controller;

import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
import com.board.beomBoard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {

    @Autowired      // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;


    @GetMapping("/articles/new")
    public String newArticleForm()
    {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm)
    {
        log.info(articleForm.toString());
        //1. DTO를 변환 ! Entity!
        Article article = articleForm.toEntity();
        //2. Repository에게 Entitiy안에 있는 DB안에 저장하게 한다.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }




}
