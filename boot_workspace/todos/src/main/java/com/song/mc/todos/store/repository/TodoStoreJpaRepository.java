package com.song.mc.todos.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoStoreJpaRepository extends JpaRepository<TodoJpo, Integer> {
	
	
}
