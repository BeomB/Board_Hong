package com.board.beomBoard.controller;

import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
import com.board.beomBoard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Slf4j
@Controller
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/api/articles")
    public List<Article> index()
    {
        return (List<Article>) articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id]")
    public List<Article> index(@PathVariable Long id)
    {
        return (List<Article>) articleRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/articles/{id}")
    public ResponseEntity<Article> create(@PathVariable Long id, @RequestBody  ArticleForm dto)
    {
        Article article = dto.toEntity();
        log.info("id: {} , article:{}",id,article.toString());
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null || id != article.getId())
        {
            log.info("잘못된 요청! id: {}, article:{}",id,article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        target.put()
        return articleRepository.save(article);
    }







}
