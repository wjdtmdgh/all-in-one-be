package com.seungho.allinonebe.article.controller;

import com.seungho.allinonebe.article.dto.ArticleDto;
import com.seungho.allinonebe.article.dto.ArticleRegisterDto;
import com.seungho.allinonebe.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getArticlePage(){
        return ResponseEntity.ok(articleService.getArticlePage());
    }

    @PostMapping
    public ResponseEntity<ArticleDto> registerArticle(@RequestBody ArticleRegisterDto registerDto){
        return ResponseEntity.ok(articleService.registerArticle(registerDto));
    }
}
