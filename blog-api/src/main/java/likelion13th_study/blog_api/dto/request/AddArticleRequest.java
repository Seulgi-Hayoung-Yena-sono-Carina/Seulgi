package likelion13th_study.blog_api.dto.request;

import likelion13th_study.blog_api.domain.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

