package com.example.mc.store.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.example.mc.users.domain.Role;
import com.example.mc.users.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class UserJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)  //JPA - Enum값 저장 타입 설정 (기본-int)
    @Column(nullable = false)
    private Role role;

    @Builder
    public UserJpo(String name, String email, String picture, Role role){
        this.name= name;
        this.email = email;
        this.picture = picture;
        this.role = Role.USER;  //test를 위해 USER로 기본값 
    }

    public UserJpo update(String name, String picture){
        this.name =name;
        this.picture=picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
    
	public User toDomain() {
		User user = User.builder()
				.id(this.id)
				.name(this.name)
				.email(this.email)
				.picture(this.picture)
				.role(this.role)
				.build();
		return user;
	}
	
}
