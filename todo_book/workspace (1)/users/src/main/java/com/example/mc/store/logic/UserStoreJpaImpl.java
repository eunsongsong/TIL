package com.example.mc.store.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mc.store.UserStore;
import com.example.mc.store.repository.UserJpo;
import com.example.mc.store.repository.UserRepository;
import com.example.mc.users.domain.User;

@Repository
public class UserStoreJpaImpl implements UserStore {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).map(UserJpo::toDomain).get();
	}
}
