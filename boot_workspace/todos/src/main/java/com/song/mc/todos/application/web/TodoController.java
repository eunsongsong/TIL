package com.song.mc.todos.application.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.mc.todos.domain.Todo;
import com.song.mc.todos.domain.service.TodoService;
import com.song.mc.todos.store.exception.DuplicateException;

@RestController
@RequestMapping("/api/todos/")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping()
	public List<Todo> todoList() {
		return service.todoList();
	}

	@GetMapping("{todoNum}")
	public Todo todoDetail(@PathVariable int todoNum) {
		return service.todoDetail(todoNum);
	}
	
	@GetMapping("{searchType}/{keyword}")
	public List<Todo> todoSearch(@PathVariable String searchType, @PathVariable String keyword){
		return service.search(keyword, searchType);
	}

	@PostMapping
	public void todoCreate(@RequestBody Todo todo) throws DuplicateException{
		service.todoCreate(todo);
	}
	
	@PutMapping
	public void todoModify(@RequestBody Todo todo) {
		service.todoModify(todo);
	}
	
	@DeleteMapping("{todoNum}")
	public void todoDelete(@PathVariable int todoNum) {
		service.todoDelete(todoNum);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody ErrorMessage runTimeError(RuntimeException e) {
		ErrorMessage error = new ErrorMessage();
		error.setMessage(e.getMessage());
		return error;
	}
	
	
}
