package com.song.mc.todos.store;

import java.util.List;
import java.util.NoSuchElementException;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.store.exception.DuplicateException;

public interface TodoStore {
	public abstract void insert(Todo todo) throws DuplicateException; // todoNum : db sequence
	public abstract void delete(int todoNum) throws NoSuchElementException;
	public abstract void update(Todo todo) throws NoSuchElementException;
	public abstract Todo findTodo(int todoNum) throws NoSuchElementException;
	public abstract List<Todo> findAll() throws NoSuchElementException;
	public abstract List<Todo> search(String keyword, String searchType) throws NoSuchElementException;
	public abstract boolean isExist(int todoNum);
}
