package com.seungho.allinonebe.article.repository;

import com.seungho.allinonebe.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
