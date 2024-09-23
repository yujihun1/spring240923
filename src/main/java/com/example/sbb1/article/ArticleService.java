package com.example.sbb1.article;

import com.example.sbb1.DataNotFoundException;
import com.example.sbb1.user.SiteUser;
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

    public void create(String title, String content, SiteUser user){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        article.setAuthor(user);
        this.articleRepository.save(article);

    }

    public void modify(Article article, String title, String content){
        article.setTitle(title);
        article.setContent(content);
        article.setModifyDae(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public void delete(Article article){
        this.articleRepository.delete(article);
    }
}
