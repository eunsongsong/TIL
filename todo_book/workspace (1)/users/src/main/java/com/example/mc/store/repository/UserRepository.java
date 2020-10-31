package com.example.mc.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpo, Long> {
	Optional<UserJpo> findByEmail(String email);
}
