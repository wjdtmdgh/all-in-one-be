package com.seungho.allinonebe.reply.controller;


import com.seungho.allinonebe.reply.dto.ReplyDto;
import com.seungho.allinonebe.reply.dto.ReplyRegisterDto;
import com.seungho.allinonebe.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/replies")
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping
    public ResponseEntity<List<ReplyDto>> getReplyPage(@RequestParam Long articleId){
        return ResponseEntity.ok(replyService.getReplyPage(articleId));
    }

    @PostMapping
    public ResponseEntity<ReplyDto> registerReply(@RequestBody ReplyRegisterDto registerDto){
        return ResponseEntity.ok(replyService.registerReply(registerDto));
    }
}
