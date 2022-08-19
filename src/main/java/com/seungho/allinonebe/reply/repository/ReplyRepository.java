package com.seungho.allinonebe.reply.repository;

import com.seungho.allinonebe.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByArticleId(Long articleId);
}
