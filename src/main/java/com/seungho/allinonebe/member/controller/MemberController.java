package com.seungho.allinonebe.member.controller;

import com.seungho.allinonebe.member.dto.MemberRegisterDto;
import com.seungho.allinonebe.member.dto.MemberResponse;
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
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDto requestDto){
        return memberService.login(requestDto);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> register(@RequestBody MemberRegisterDto requestDto){
        log.info("requestDto: {}", requestDto);
        return ResponseEntity.ok(memberService.register(requestDto));
    }
}
