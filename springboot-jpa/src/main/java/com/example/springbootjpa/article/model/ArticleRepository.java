package com.example.springbootjpa.article.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gihyung.lee
 * @since 2022/02/04
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
