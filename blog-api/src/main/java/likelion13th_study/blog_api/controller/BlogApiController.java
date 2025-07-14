package likelion13th_study.blog_api.controller;

import likelion13th_study.blog_api.domain.Article;
import likelion13th_study.blog_api.dto.request.AddArticleRequest;
import likelion13th_study.blog_api.dto.request.UpdateArticleRequest;
import likelion13th_study.blog_api.dto.response.ArticleResponse;
import likelion13th_study.blog_api.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;


    //ArticleResponse로 불러서 필요 정보만 빼내기
    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED) //JSON 파일로 다시 변환
                .body(new ArticleResponse(savedArticle));
    }

    //article 모두 출력하기
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/article/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable("id") long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> DeleteArticle(@PathVariable("id") long id){
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody UpdateArticleRequest request){
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
//    Article을 그대로 부르기
//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
//        Article savedArticle = blogService.save(request);
//
//        return ResponseEntity.status(HttpStatus.CREATED) //JSON 파일로 다시 변환
//                .body(savedArticle);
//    }

}
