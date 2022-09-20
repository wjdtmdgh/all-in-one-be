package com.seungho.allinonebe.member.service;

import com.seungho.allinonebe.member.dto.LoginRequestDto;
import com.seungho.allinonebe.member.dto.MemberRegisterDto;
import com.seungho.allinonebe.member.dto.MemberResponse;
import com.seungho.allinonebe.member.dto.TokenResponse;
import com.seungho.allinonebe.member.entity.Member;
import com.seungho.allinonebe.member.repository.MemberRepository;
import com.seungho.allinonebe.security.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;


    public ResponseEntity<TokenResponse> login(LoginRequestDto requestDto){
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            Member member = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow(RuntimeException::new);
            TokenResponse tokenResponse = TokenResponse.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(requestDto.getEmail())
                    .token(jwtTokenProvider.generateToken(authentication))
                    .build();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + tokenResponse.getToken());

            return new ResponseEntity<>(tokenResponse, httpHeaders, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials supplied");
        }
    }

    @Transactional
    public MemberResponse register(MemberRegisterDto requestDto){
        memberRepository.findByEmail(requestDto.getEmail())
                .ifPresent((tmp) -> {throw new RuntimeException("이미 가입한 회원입니다.");});

        Member member = Member.builder()
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .password(bCryptPasswordEncoder.encode(requestDto.getPassword()))
                .build();

        member = memberRepository.save(member);

        return MemberResponse.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }

}
