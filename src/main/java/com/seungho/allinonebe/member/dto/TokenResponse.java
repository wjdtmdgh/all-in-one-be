package com.seungho.allinonebe.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TokenResponse {
    private Long id;
    private String name;
    private String email;
    private String token;
}
