package com.example.mc.application.config.auth;


import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.mc.application.config.auth.dto.OAuthAttributes;
import com.example.mc.application.config.auth.dto.SessionUser;
import com.example.mc.store.repository.UserJpo;
import com.example.mc.store.repository.UserRepository;
import com.example.mc.users.domain.User;

@Service
public class CustomOAuth2UserService  //로그인 성공 후 email, name, picture(구글등록시 범위) 정보 가입, 정보수정, 세션 저장 등 지원
        implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
	private HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
       OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate =
               new DefaultOAuth2UserService();
       OAuth2User oAuth2User = delegate.loadUser(userRequest);
       //로그인 진행중인 서비스 식별자(구글, 네이버, 페이스북...)
       String registrationId = userRequest.getClientRegistration().getRegistrationId();

       //OAuth2 로그인 진행시 키가 되는 필드 값(primary key)
       String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                                                .getUserInfoEndpoint().getUserNameAttributeName();

       //OAuth2UserService를 통해 가져온  OAuth2User의 attribute를 담는 클래스
       OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
                                                    oAuth2User.getAttributes());
       User user = saveOrUpdate(attributes);
       //SessionUser : Session에 사용자 정보를 저장하기 위한 Dto 클래스
       httpSession.setAttribute("user", new SessionUser(user));

       return new DefaultOAuth2User(
               Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
               attributes.getAttributes(),
               attributes.getNameAttributeKey()
       );
    }

    private User saveOrUpdate(OAuthAttributes attributes){
        UserJpo user = userRepository.findByEmail(attributes.getEmail())
                .map(entity->entity.update(attributes.getName(),
                                            attributes.getPicture()))
                .orElse(UserJpo.builder()
                		.name(attributes.getName())
                		.email(attributes.getEmail())
                		.picture(attributes.getPicture())
                		.build());
        return userRepository.save(user).toDomain();
    }

}
