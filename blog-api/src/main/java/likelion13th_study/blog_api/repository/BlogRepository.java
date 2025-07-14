package likelion13th_study.blog_api.repository;

import likelion13th_study.blog_api.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
