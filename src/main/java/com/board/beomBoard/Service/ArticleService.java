package com.board.beomBoard.Service;

import com.board.beomBoard.dto.ArticleForm;
import com.board.beomBoard.entity.Article;
import com.board.beomBoard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service        // 서비스 선언! (서비스 객체를 스프링 부트에 생성)
public class ArticleService {

    @Autowired      //DI
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article != null)
        {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1.수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id:{}, article:{}", id, article.toString());

        // 2.대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //3.잘못된 요청 처리
        if (target == null || id != article.getId()) {
            log.info("잘못도니 요청! id:{}, article:{}", id, article.toString());
            return null;
        }
        target.patch(article);
        Article updateArticle =articleRepository.save(target);
        return updateArticle;
    }

    public Article delete(Long id)
    {
        Article deleteArticle = articleRepository.findById(id).orElse(null);
        if (deleteArticle==null)
        {
            return null;
        }
        articleRepository.delete(deleteArticle);
        return deleteArticle;
    }




}
