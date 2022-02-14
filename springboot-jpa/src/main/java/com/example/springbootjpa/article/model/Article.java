package com.example.springbootjpa.article.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

/**
 * save, saveAll 성능 체크용 게시글 엔티티
 * @author gihyung.lee
 * @since 2022/02/04
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "content")
    private String content;

    public Article(String content) {
        this.content = content;
    }
}
