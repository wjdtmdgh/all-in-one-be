package com.seungho.allinonebe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
