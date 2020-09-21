package com.song.myspringboot.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.myspringboot.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

//	@Test
//	public void update() {
//
//		Optional<User> optional = repository.findById(2L);
//		
//		// 요청한 ID를 가진 User가 있으면 갱신하기
//		if (optional.isPresent()) {
//			User user = optional.get();
//			user.setEmail("email@email.com"); 
//			repository.save(user);
//		}
//
//	}
	
	

}
