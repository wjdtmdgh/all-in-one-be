package com.seungho.allinonebe.article.service;

import com.seungho.allinonebe.article.dto.ArticleDto;
import com.seungho.allinonebe.article.dto.ArticleRegisterDto;
import com.seungho.allinonebe.article.entity.Article;
import com.seungho.allinonebe.article.repository.ArticleRepository;
import com.seungho.allinonebe.member.entity.Member;
import com.seungho.allinonebe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public List<ArticleDto> getArticlePage(){
        return articleRepository.findAll().stream()
                .map(article -> {

                    Member member = memberRepository.findById(article.getWriterId())
                            .orElseThrow(RuntimeException::new);

                    return ArticleDto.builder()
                            .id(article.getId())
                            .title(article.getTitle())
                            .contents(article.getContents())
                            .writerId(article.getWriterId())
                            .writerName(member.getName())
                            .language(article.getLanguage())
                            .pageView(article.getPageView())
                            .favoriteCount(article.getFavoriteCount())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public ArticleDto getArticleDetail(Long articleId){
        return articleRepository.findById(articleId)
                .map(article -> {
                    Member member = memberRepository.findById(article.getWriterId())
                            .orElseThrow(RuntimeException::new);
                    return ArticleDto.builder()
                            .id(article.getId())
                            .title(article.getTitle())
                            .contents(article.getContents())
                            .writerId(article.getWriterId())
                            .writerName(member.getName())
                            .language(article.getLanguage())
                            .pageView(article.getPageView())
                            .favoriteCount(article.getFavoriteCount())
                            .build();
                }).orElseThrow(RuntimeException::new);
    }

    public ArticleDto registerArticle(ArticleRegisterDto registerDto){
        Article article = articleRepository.save(Article.builder()
                .title(registerDto.getTitle())
                .contents(registerDto.getContents())
                .writerId(registerDto.getWriterId())
                .language(registerDto.getLanguage())
                .pageView(0L)
                .favoriteCount(0L)
                .build());

        Member member = memberRepository.findById(article.getWriterId())
                .orElseThrow(RuntimeException::new);

        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .contents(article.getContents())
                .writerId(article.getWriterId())
                .writerName(member.getName())
                .language(article.getLanguage())
                .pageView(article.getPageView())
                .favoriteCount(article.getFavoriteCount())
                .build();
    }

}
