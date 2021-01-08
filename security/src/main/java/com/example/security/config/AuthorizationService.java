package com.example.security.config;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthorizationService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
