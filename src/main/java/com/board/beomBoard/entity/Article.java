package com.board.beomBoard.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity     // Entity임을 알려줘야 해당 DB가 객체 인식 가능!
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


}
