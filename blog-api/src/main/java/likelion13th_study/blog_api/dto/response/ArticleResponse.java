package likelion13th_study.blog_api.dto.response;

import likelion13th_study.blog_api.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static ArticleResponse from(Article article) {
        return new ArticleResponse(article.getTitle(), article.getContent());
    }
}
