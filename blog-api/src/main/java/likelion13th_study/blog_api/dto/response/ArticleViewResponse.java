package likelion13th_study.blog_api.dto.response;

import likelion13th_study.blog_api.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }

    public ArticleViewResponse() {
        this.id = null;
        this.title = "";
        this.content = "";
        this.createdAt = null;
    }
}
