package com.seungho.allinonebe.reply.entity;

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
@Table(name = "reply")
public class Reply extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="article_id", nullable = false)
    private Long articleId;

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    private String contents;
}
