package com.board.beomBoard.dto;

import com.board.beomBoard.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ArticleForm {

    private  Long id;
    private String title;
    private String content;





    public Article toEntity() {
        return new Article(id,title,content);
    }
}
