package com.song.mc.todos.domain.service.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.domain.service.TodoService;
import com.song.mc.todos.store.TodoStore;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoStore store;

	@Override
	public void todoCreate(Todo todo) {
		store.insert(todo);

	}

	@Override
	public Todo todoDetail(int todoNum) throws NoSuchElementException {
		return store.findTodo(todoNum);
	}

	@Override
	public List<Todo> todoList() throws NoSuchElementException {
		return store.findAll();
	}

	@Override
	public void todoModify(Todo todo) throws NoSuchElementException {
		store.update(todo);
	}

	@Override
	public void todoDelete(int todoNum) throws NoSuchElementException {
		store.delete(todoNum);
	}

}
