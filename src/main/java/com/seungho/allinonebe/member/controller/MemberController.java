package com.seungho.allinonebe.member.controller;

import com.seungho.allinonebe.member.dto.MemberRegisterDto;
import com.seungho.allinonebe.member.dto.TokenResponse;
import com.seungho.allinonebe.member.service.MemberService;
import com.seungho.allinonebe.member.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto){
        return ResponseEntity.ok(TokenResponse.builder().token(memberService.login(requestDto)).build());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody MemberRegisterDto requestDto){
        log.info("requestDto: {}", requestDto);
        memberService.register(requestDto);
        return ResponseEntity.ok(TokenResponse.builder().token("token_abcd1234").build());
    }
}
