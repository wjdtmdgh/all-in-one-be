package com.seungho.allinonebe.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRegisterDto {
    private String contents;
    private Long articleId;
    private Long writerId;
}
