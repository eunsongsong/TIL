package com.example.mc.users.domain;

import lombok.Builder;
import lombok.Getter;

//login oauth클라이언트 데이터 연동
@Getter
public class User {
	private Long id; //db sequence로 생성
	private String name; 
	private String email;//사용자 session 정보
	private String picture;
	private Role role;   //oauth인증 받은 사용자 권한 enum type

	@Builder
	public User(Long id, String name, String email, String picture, Role role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;	
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}
