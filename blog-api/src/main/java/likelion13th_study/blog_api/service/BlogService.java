package likelion13th_study.blog_api.service;

import jakarta.transaction.Transactional;
import likelion13th_study.blog_api.domain.Article;
import likelion13th_study.blog_api.dto.request.AddArticleRequest;
import likelion13th_study.blog_api.dto.request.PatchArticleRequest;
import likelion13th_study.blog_api.dto.request.UpdateArticleRequest;
import likelion13th_study.blog_api.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("잘못된 아이디입니다." + id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }

    public Article patch(Long id, PatchArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        article.patch(request.getTitle(), request.getContent());
        return article;
    }

}
