package com.seungho.allinonebe;

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
}
