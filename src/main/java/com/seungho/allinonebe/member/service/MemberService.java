package com.seungho.allinonebe.member.service;

import com.seungho.allinonebe.member.dto.LoginRequestDto;
import com.seungho.allinonebe.member.dto.MemberRegisterDto;
import com.seungho.allinonebe.member.entity.Member;
import com.seungho.allinonebe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String login(LoginRequestDto requestDto){
        Optional<Member> result = memberRepository.findByEmail(requestDto.getEmail());
        if(result.isPresent()){
            Member member = result.get();
            if(requestDto.getPassword().equals(member.getPassword())) {
                return "login success";
            }
            return "password incorrect";
        }
        return "email not found";
    }

    public void register(MemberRegisterDto requestDto){
        Member member = Member.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();

        memberRepository.save(member);
    }
}
