package com.board.beomBoard.Service;

import com.board.beomBoard.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest             //해당 클래스는 스프링부트와 연동되어 테스팅된다.
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

//    @Test
//    void index() {
//
//        // 예상
//        Article a = new Article(1L,"가가가가","1111");
//        Article b = new Article(2L,"가가가가","2222");
//        Article c = new Article(3L,"가가가가","3333");
//        List<Article> expectList = new ArrayList<Article>(Arrays.asList(a,b,c));
//
//        //실제
//        List<Article> articles = articleService.index();
//
//        //비교
//        assertEquals(expectList.toString(),articles.toString());
//
//    }


    @Test
    void show_성공() {
        //예상
        Article expected = new Article(1L,"가가가가","1111");
        //실제
        Article article = articleService.show(1L);
        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    void show_실패() {
        //예상
        Article expected = new Article(1L,"가가가가","1111");
        //실제
        Article article = articleService.show(1L);
        //비교
        assertEquals(expected.toString(),article.toString());
    }
}

