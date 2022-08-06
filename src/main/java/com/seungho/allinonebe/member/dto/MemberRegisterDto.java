package com.seungho.allinonebe.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberRegisterDto {
    private String email;
    private String name;
    private String password;
}
