package com.seungho.allinonebe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class MemberRegisterDto {
    private String email;
    private String password;
}
