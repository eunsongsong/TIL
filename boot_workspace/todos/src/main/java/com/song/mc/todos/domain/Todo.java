package com.song.mc.todos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
			generator = "TODO_SEQ_GEN" // 식별자 생성기를 설정해놓은 TODO_SEQ_GEN으로 설정
	)
	private int todoNum;
	private String title;
	private String contents;
	private String startDate;
	private String endDate;

	@Override
	public String toString() {
		Gson json = new Gson();
		return json.toJson(this); // 현재 객체의 데이터를 제이슨 형태로 리턴
	}

	public static Todo sample() {
		return new Todo(0, "title", "content", "20200923", "20200323");
	}

	public static void main(String[] args) {
		System.out.println(Todo.sample());
	}
}
