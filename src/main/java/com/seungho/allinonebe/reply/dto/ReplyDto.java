package com.seungho.allinonebe.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReplyDto {
    private Long id;
    private String contents;
    private Long articleId;
    private Long writerId;
    private String writerName;
    private String writerEmail;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
