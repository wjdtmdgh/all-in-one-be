package com.seungho.allinonebe.member.service;

import com.seungho.allinonebe.member.dto.LoginRequestDto;
import com.seungho.allinonebe.member.dto.MemberRegisterDto;
import com.seungho.allinonebe.member.entity.Member;
import com.seungho.allinonebe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
                return "token_login_abcd1234";
            }
            throw new RuntimeException("비밀번호 불일치");
        }
        throw new RuntimeException("가입한 회원이 아님");
    }

    @Transactional
    public void register(MemberRegisterDto requestDto){
        memberRepository.findByEmail(requestDto.getEmail())
                .ifPresent((tmp) -> {throw new RuntimeException();});

        Member member = Member.builder()
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .password(requestDto.getPassword())
                .build();

        memberRepository.save(member);
    }
}
