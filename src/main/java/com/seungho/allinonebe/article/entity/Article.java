package com.seungho.allinonebe.article.entity;

import com.seungho.allinonebe.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "article")
public class Article extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "page_view", nullable = false)
    private Long pageView;

    @Column(name = "favorite_count", nullable = false)
    private Long favoriteCount;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContents(String contents){
        this.contents = contents;
    }

    public void changeLanguage(String language){
        this.language = language;
    }
}
