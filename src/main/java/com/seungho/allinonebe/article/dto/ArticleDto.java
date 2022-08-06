package com.seungho.allinonebe.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String contents;
    private Long writerId;
    private String writerName;
    private String language;
    private Long pageView;
    private Long favoriteCount;
}
