package com.example.springbootjpa.article.repository;

import com.example.springbootjpa.article.model.Article;
import com.example.springbootjpa.article.model.ArticleRepository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;


/**
 * JPA save, saveAll 예제
 * save, saveAll 성능비교
 * @author gihyung.lee
 * @since 2022/02/04
 */
@SpringBootTest
public class ArticleRepositoryTests {

    @Autowired
    ArticleRepository repository;

    // 저장 배열
    private List<Article> list = Lists.newArrayList();

    @BeforeEach
    void init() {
        IntStream.range(0, 100000).forEach(index -> list.add(new Article("게시글 본문입니다.")));
    }

    /**
     * 10만건 saveAll
     * @throws Exception
     */
    @Test
    public void SaveAllTest() throws Exception {
        repository.saveAll(list);
    }

    /**
     * 10만건 하나씩 save
     * @throws Exception
     */
    @Test
    public void SaveTest() throws Exception {
        list.forEach(entity -> repository.save(entity));
    }

}
