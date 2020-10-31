package com.example.mc.store;

import com.example.mc.users.domain.User;

public interface UserStore {
	public User findByEmail(String email);
}
