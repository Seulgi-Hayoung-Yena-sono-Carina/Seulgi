package likelion13th_study.blog_api.testData;

import jakarta.annotation.PostConstruct;
import likelion13th_study.blog_api.domain.Article;
import likelion13th_study.blog_api.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestData{

    private final BlogRepository blogRepository;

    @PostConstruct //Spring Bean이 생성되고 의존성 주입이 완료된 후 자동으로 실행
    public void init() {
        blogRepository.save(new Article("제목 1", "내용 1"));
        blogRepository.save(new Article("제목 2", "내용 2"));
        blogRepository.save(new Article("제목 3", "내용 3"));
    }
}