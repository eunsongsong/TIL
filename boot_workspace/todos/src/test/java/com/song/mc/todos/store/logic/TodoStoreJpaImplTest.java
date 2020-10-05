package com.song.mc.todos.store.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.store.repository.TodoJpo;
import com.song.mc.todos.store.repository.TodoStoreJpaRepository;
import com.song.mc.todos.store.repository.TodoStoreJpaRepositoryCustom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoStoreJpaImplTest {

	@Autowired
	TodoStoreJpaRepository repository;
	
	@Autowired
	TodoStoreJpaRepositoryCustom todoSearch;

//	@Before
//	public void setUp() {
//		repository.save(new TodoJpo(Todo.sample()));
//	}
//	
//	@After
//	public void clean() {
//		repository.deleteAll();
//	}
	
	@Test
	public void testFindAll() {
		List<TodoJpo> todos = repository.findAll();
		Todo todo = todos.get(0).toDomain();
		assertEquals(todo.getTitle(), "title");
	}
	
	@Test
	public void testFindTodo() {
		Todo todo = repository.findById(1).get().toDomain();
		assertEquals(todo.getTitle(), "title");
	}
	
	@Test
	public void testInsert() {
		repository.save(new TodoJpo(Todo.sample2()));
	}
	
	@Test
	public void testUpdate() {
		Todo todo = repository.getOne(1).toDomain();
//		Todo todo = repository.findById(1).get().toDomain();
		todo.setTitle("Title");
		repository.save(new TodoJpo(todo));
	
//		todo = repository.findById(1).get().toDomain();
//		assertEquals(todo.getTitle(), "Title");
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(1);
//		repository.deleteAll();
	}

}
