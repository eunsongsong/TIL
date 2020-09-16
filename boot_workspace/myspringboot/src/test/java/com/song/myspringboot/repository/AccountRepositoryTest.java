package com.song.myspringboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository repository;
	
	// test는 자동실행 안됨, ctrl+f11으로 실행 
	@Test
	public void account() throws Exception {
		System.out.println(repository.getClass().getName());
		// 1. Account 객체 생성 -> 등록
		Account account = new Account();
		account.setUsername("test");
		account.setPassword("1234");
		
		Account addAccount = repository.save(account); // save메서드 호출하면 등록
		System.out.println(addAccount.getId() + " " + addAccount.getUsername());
		
	}
	
}
