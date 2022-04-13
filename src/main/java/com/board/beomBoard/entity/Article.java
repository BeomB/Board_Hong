package com.board.beomBoard.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity     // Entity임을 알려줘야 해당 DB가 객체 인식 가능!
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //DB가 id를 자동 생성한다.
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


    public void patch(Article article) {
        if (article.title!=null)
        {
            this.title = article.title;
        }
        if (article.content!=null)
        {
            this.content = article.content;
        }
    }
}
