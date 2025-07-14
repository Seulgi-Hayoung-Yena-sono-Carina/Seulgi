package likelion13th_study.blog_api.service;

import likelion13th_study.blog_api.domain.Article;
import likelion13th_study.blog_api.dto.request.AddArticleRequest;
import likelion13th_study.blog_api.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
