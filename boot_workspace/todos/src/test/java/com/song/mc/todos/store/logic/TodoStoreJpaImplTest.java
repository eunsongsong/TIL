package com.song.mc.todos.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.store.repository.TodoJpo;
import com.song.mc.todos.store.repository.TodoStoreJpaRepository;
import com.song.mc.todos.store.repository.TodoStoreJpaRepositoryCustom;

public class TodoStoreJpaImplTest {

	@Autowired
	TodoStoreJpaRepository repository;
	
	@Autowired
	TodoStoreJpaRepositoryCustom todoSearch;

	@Before
	public void setUp() {
		repository.save(new TodoJpo(Todo.sample()));
	}
	
	@After
	public void clean() {
		repository.deleteAll();
	}
	
	@Test
	public void testFindAll() {
		List<TodoJpo> todos = repository.findAll();
		Todo todo = todos.get(0).toDomain();
		assertEquals(todo.getTitle(), "title");
	}

}
