package com.song.mc.todos.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.song.mc.todos.domain.Todo;

public interface TodoService {
	// interface : public abstract method, public final static variable

	public abstract void todoCreate(Todo todo);
	public abstract Todo todoDetail(int todoNum) throws NoSuchElementException;
	public abstract List<Todo> todoList();
	public abstract void todoModify(Todo todo) throws NoSuchElementException;
	public abstract void todoDelete(int todoNum) throws NoSuchElementException;
	
}
