package com.seungho.allinonebe.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        log.info(request.getRequestURI());
        log.error("UnAuthorized -- message : " + e.getMessage());
        response.sendError(e.hashCode(), e.getMessage());
//        response.sendRedirect("/auth/signIn");
    }
}