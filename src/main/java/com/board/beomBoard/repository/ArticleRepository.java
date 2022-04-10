package com.board.beomBoard.repository;


import com.board.beomBoard.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
