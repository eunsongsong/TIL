package com.example.mc.application.config.auth.dto;

import java.util.Map;
import com.example.mc.users.domain.Role;
import com.example.mc.users.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {//OAuth - 구글, 네이버 페이스북 트위터 등  어떤 OAuth서비스를 생성하는지에 따라 정보 받아오기 
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                          String nameAttributeKey, String name,
                          String email, String picture){
        this.attributes =attributes;
        this.nameAttributeKey =nameAttributeKey;
        this.name=name;
        this.email=email;
        this.picture=picture;
    }

    //Map 의 값 하나하나 반환
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
//        if("naver".equals(registrationId)) {
//            return ofNaver("id", attributes);
//        }else if("facebook".equals(registrationId){
//            return ofFaceBook("id", attributes);
//        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    //google
    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .picture((String)attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //User 엔티티
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}
