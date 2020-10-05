package com.song.mc.todos.store.logic;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.store.TodoStore;
import com.song.mc.todos.store.exception.DuplicateException;
import com.song.mc.todos.store.repository.TodoJpo;
import com.song.mc.todos.store.repository.TodoStoreJpaRepository;
import com.song.mc.todos.store.repository.TodoStoreJpaRepositoryCustom;

@Repository
public class TodoStoreJpaImpl implements TodoStore {

	@Autowired
	TodoStoreJpaRepository repository;

	@Autowired
	TodoStoreJpaRepositoryCustom todoSearch;

	@Override
	public List<Todo> findAll() throws NoSuchElementException {
		List<TodoJpo> todos = repository.findAll();
		if (todos.isEmpty())
			throw new NoSuchElementException("todos empty");
		return TodoJpo.toDomains(todos);
	}

	@Override
	public Todo findTodo(int todoNum) throws NoSuchElementException {
		Optional<TodoJpo> todoJpo = repository.findById(todoNum);
		if (todoJpo == null)
			throw new NoSuchElementException(todoNum + " todo not exist.");
		return todoJpo.map(TodoJpo::toDomain).get();
	}

	@Override
	public void insert(Todo todo) throws DuplicateException {
		repository.save(new TodoJpo(todo));
	}

	@Override
	public void delete(int todoNum) throws NoSuchElementException {
		repository.deleteById(todoNum);
	}

	@Override
	public void update(Todo todo) throws NoSuchElementException {
		repository.save(new TodoJpo(todo));
	}

	@Override
	public List<Todo> search(String keyword, String searchType) {
		String query = "SELECT * FROM todos WHERE " + searchType + " like '%" + keyword + "%'";
		List<TodoJpo> todos = todoSearch.findByQuery(query);

		if (todos.isEmpty())
			throw new NoSuchElementException("todos empty");

		return TodoJpo.toDomains(todos);
	}

	@Override
	public boolean isExist(int todoNum) {
		Optional<TodoJpo> todo = repository.findById(todoNum);
		if (todo == null)
			return false;
		return true;
	}

}
