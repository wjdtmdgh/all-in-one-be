package com.seungho.allinonebe.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ArticleModifyDto {
    private String title;
    private String contents;
    private String language;
}
