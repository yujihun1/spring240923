package com.example.sbb1.article;

import com.example.sbb1.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList(){
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        }else{
            throw new DataNotFoundException("article not found");
        }

    }

    public void create(String title,String content){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);

    }
}
