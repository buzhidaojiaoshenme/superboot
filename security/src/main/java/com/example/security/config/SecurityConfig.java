package com.example.security.config;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //认证
        http.formLogin()
                .loginPage("/login.html")
                //只能是post请求
                .loginProcessingUrl("/login")
                //只能是post请求
                .successForwardUrl("/toMain")
                //只能是post请求
                .failureForwardUrl("/toError");

        //授权
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/main.html").permitAll()
                //?匹配一个字符,*匹配0个或多个字符,**匹配0个或多个目录
                .antMatchers("/js/**", "/css/**").permitAll()
                //正则表达式匹配
                //.regexMatchers("[]").permitAll()
                //权限控制
                //.antMatchers("/niubi.html").hasAuthority("niubi")
                .anyRequest().access("@authorizationServiceImpl.hasPermission(request, authentication)");
                //.anyRequest().authenticated();

        //设置访问拒绝处理器
        http.exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandlerImpl());

        //配置logout信息
//        http.logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login.html");

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
