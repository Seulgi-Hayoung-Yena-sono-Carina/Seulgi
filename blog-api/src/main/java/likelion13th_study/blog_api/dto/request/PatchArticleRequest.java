package likelion13th_study.blog_api.dto.request;

import lombok.Getter;

@Getter
public class PatchArticleRequest {
    private String title;   // null이면 수정하지 않음
    private String content; // null이면 수정하지 않음
}