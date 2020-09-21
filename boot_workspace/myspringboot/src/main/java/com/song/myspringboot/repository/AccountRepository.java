package com.song.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.myspringboot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
	Optional<Account> findByEmail(String email);
}
