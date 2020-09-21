package com.song.myspringboot.repository;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.junit.Ignore;
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

	@Test //@Ignore
	public void update() {
		Optional<Account> optional = repository.findById(2L);

		// 요청한 ID를 가진 Account가 있으면 갱신하기
		if (optional.isPresent()) {
			Account account = optional.get();
			account.setEmail("test@email.com");
			repository.save(account);
		}

	}

	@Test //@Ignore
	public void finder() {
		Account account = repository.findByUsername("lambda");
		System.out.println(account);

		Optional<Account> optional = repository.findById(1L);
		System.out.println(optional.isPresent());
		if (optional.isPresent()) {
			Account account2 = optional.get();
			System.out.println(account2);
		}
		// 요청 ID가 있으면 Account 객체를 반환하고, 없으면 예외를 발생시켜봅니다.
		Optional<Account> optEmail = repository.findByEmail("lambda@email.com");
		System.out.println(optEmail.isPresent());
		// Suppler 함수형 인터페이스의 추상메서드 : T get()
		Account account3 = optEmail.orElseThrow(() -> new RuntimeException("요청한 Email 주소를 가진 Account가 없음!"));
		System.out.println(account3);
		
		List<Account> accountList = repository.findAll(); // Iterable
		accountList.forEach(acct ->System.out.println(acct));
		accountList.forEach(System.out::println);
	}

	// test는 자동실행 안됨, ctrl+f11으로 실행
	@Test
	@Ignore
	public void account() throws Exception {
		System.out.println(repository.getClass().getName());
		// 1. Account 객체 생성 -> 등록
		Account account = new Account();
		account.setUsername("lambda");
		account.setPassword("1234");
		account.setEmail("lambda@email.com");

		Account addAccount = repository.save(account); // save메서드 호출하면 등록
		System.out.println(addAccount.getId() + " " + addAccount.getUsername());

	}

}
