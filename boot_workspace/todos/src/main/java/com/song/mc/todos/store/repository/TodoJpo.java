package com.song.mc.todos.store.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.song.mc.todos.domain.Todo;

import lombok.Data;

@SequenceGenerator(name = "TODO_SEQ_GEN", // 시퀀스 제너레이터 이름
		sequenceName = "TODO_SEQ", // 시퀀스 이름
		initialValue = 1, // 시작값
		allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)
@Entity
@Data
@Table(name = "todos")
public class TodoJpo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
			generator = "TODO_SEQ_GEN" // 식별자 생성기를 설정해놓은 TODO_SEQ_GEN으로 설정
	)
	@Column(nullable = false, unique = true)
	private int todoNum;
	@Column(nullable = false)
	private String title;
	private String contents;
	@Column(nullable = false)
	private String startDate;
	private String endDate;

	public TodoJpo() {
		super();
	}

	public TodoJpo(Todo todo) {
		super();
		BeanUtils.copyProperties(todo, this);
	}

	public Todo toDomain() {
		Todo todo = new Todo();
		BeanUtils.copyProperties(this, todo);
		return todo;
	}

	public static List<Todo> toDomains(List<TodoJpo> todoJpos) {
		return todoJpos.stream().map(TodoJpo::toDomain).collect(Collectors.toList());
	}

}
