package com.example.mc.users.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //private final 변수 생성자 초기화
public enum Role { 
	
	GUEST("ROLE_GUEST", "비회원"),
	USER("ROLE_USER", "회원"),
	MANAGER("ROLE_MANAGER", "관리자");
	
	private final String key;
	private final String title;

}
