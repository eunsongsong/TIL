package com.song.mc.todos.store.exception;

public class DuplicateException extends RuntimeException {
	public DuplicateException() {
		super("already exist");
	}

	public DuplicateException(String message) {
		super(message + " already exist");
	}
}
