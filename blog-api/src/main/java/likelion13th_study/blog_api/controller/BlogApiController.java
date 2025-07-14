package likelion13th_study.blog_api.controller;

import likelion13th_study.blog_api.domain.Article;
import likelion13th_study.blog_api.dto.request.AddArticleRequest;
import likelion13th_study.blog_api.dto.response.ArticleResponse;
import likelion13th_study.blog_api.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED) //JSON 파일로 다시 변환
                .body(ArticleResponse.from(savedArticle));
    }

}
