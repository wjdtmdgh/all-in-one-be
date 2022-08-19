package com.seungho.allinonebe.reply.service;

import com.seungho.allinonebe.member.entity.Member;
import com.seungho.allinonebe.member.repository.MemberRepository;
import com.seungho.allinonebe.reply.dto.ReplyDto;
import com.seungho.allinonebe.reply.dto.ReplyRegisterDto;
import com.seungho.allinonebe.reply.entity.Reply;
import com.seungho.allinonebe.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;

    public List<ReplyDto> getReplyPage(Long articleId){
        return replyRepository.findAllByArticleId(articleId).stream()
                .map(reply -> {
                    Member member = memberRepository.findById(reply.getWriterId())
                            .orElseThrow(RuntimeException::new);

                    return ReplyDto.builder()
                            .id(reply.getId())
                            .contents(reply.getContents())
                            .articleId(reply.getArticleId())
                            .writerId(reply.getWriterId())
                            .writerName(member.getName())
                            .writerEmail(member.getEmail())
                            .createdDate(reply.getCreatedDate())
                            .updatedDate(reply.getUpdatedDate())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public ReplyDto registerReply(ReplyRegisterDto registerDto){
        Reply reply = replyRepository.save(Reply.builder()
                .contents(registerDto.getContents())
                .writerId(registerDto.getWriterId())
                .articleId(registerDto.getArticleId())
                .build());

        Member member = memberRepository.findById(reply.getWriterId())
                .orElseThrow(RuntimeException::new);

        return ReplyDto.builder()
                .id(reply.getId())
                .contents(reply.getContents())
                .articleId(reply.getArticleId())
                .writerId(reply.getWriterId())
                .writerName(member.getName())
                .writerEmail(member.getEmail())
                .createdDate(reply.getCreatedDate())
                .updatedDate(reply.getUpdatedDate())
                .build();
    }
}
