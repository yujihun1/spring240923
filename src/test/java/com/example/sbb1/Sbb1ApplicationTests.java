package com.example.sbb1;

import com.example.sbb1.article.Article;
import com.example.sbb1.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Sbb1ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testJpa() {
		Article q1 = new Article();
		q1.setTitle("test111");
		q1.setContent("test111");
		q1.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(q1);  // 첫번째 질문 저장

	}

}
