package com.board.beomBoard.controller;

<<<<<<< HEAD
import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
import com.board.beomBoard.repository.ArticleRepository;
=======
import com.board.beomBoard.Service.ArticleService;
import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
>>>>>>> 04dba0f ("댓글 시작까지")
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
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






=======
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController //REST API 용 컨트롤러! 데이터JSON 변환
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return (List<Article>) articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }
//
    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> Create(@RequestBody ArticleForm dto) {
        Article createArticle = articleService.create(dto);
        return (createArticle!=null)? ResponseEntity.status(HttpStatus.OK).body(createArticle):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//
    //PUT
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {

       Article updateArticle = articleService.update(id,dto);
        return (updateArticle!=null)? ResponseEntity.status(HttpStatus.OK).body(updateArticle):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//
    //DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ///1. 대상 엔티티 찾기
        Article deleteArticle = articleService.delete(id);
        return (deleteArticle != null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


    }
//
>>>>>>> 04dba0f ("댓글 시작까지")

}
