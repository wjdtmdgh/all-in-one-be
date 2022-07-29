package com.seungho.allinonebe.controller;

import com.seungho.allinonebe.dto.MemberRegisterDto;
import com.seungho.allinonebe.service.MemberService;
import com.seungho.allinonebe.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto requestDto){
        return memberService.login(requestDto);
    }

    @PostMapping
    public void register(@RequestBody MemberRegisterDto requestDto){
        log.info("requestDto: {}", requestDto);
        memberService.register(requestDto);
    }

}
