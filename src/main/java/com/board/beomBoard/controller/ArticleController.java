package com.board.beomBoard.controller;

import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
import com.board.beomBoard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model)
    {
        log.info("id = "+id);
        //1.id로 데이터를 가져온다.
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록!
        model.addAttribute("article",articleEntity);
        //3. 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model)
    {
        // 1. 모든 Article을 가져온다.
//        List<Article> articleList= (List<Article>)articleRepository.findAll();
          Iterable<Article> articleList= articleRepository.findAll();
        // 2. 가져온 Article 묶음을 뷰로 전달한다.
        model.addAttribute("articleList",articleList);
        // 3. 뷰 페이지를 설정한다.
        return "articles/index";
    }




}
