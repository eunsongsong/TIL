package com.example.mc.application.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.mc.users.domain.Role;

@EnableWebSecurity  //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomOAuth2UserService customOAuth2UserService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .headers().frameOptions().disable()//h2-console 사용위해 csrf header setting
                .and()
                    .authorizeRequests() //URL별 권한관리 설정 시작
                    .antMatchers("/", "/login","/users/**","/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 모두 사용
                    .antMatchers("/api/**").hasRole(Role.USER.name())
                    .antMatchers("/api/**").hasRole(Role.MANAGER.name())//권한관리대상 지정: /api/** 요청은 USER, MANAGR 사용자 허용
                    .anyRequest().authenticated() //설정외 나머지 URL은 인증된 사용자에게 허용
                .and()
                     .oauth2Login() //oauth2 login 설정
                        .userInfoEndpoint() //oauth2 login 성공시 사용자정보 
                         .userService(customOAuth2UserService); //로그인 성공후 로직(서비스)
        }

}


