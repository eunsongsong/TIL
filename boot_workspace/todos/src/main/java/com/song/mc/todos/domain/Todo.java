package com.song.mc.todos.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {

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
		return new Todo(1, "title", "content", "2020-09-23", "2020-03-23");
	}
	
	public static Todo sample2() {
		return new Todo(2, "title2", "content2", "2020-09-23", "2020-03-23");
	}

	public static void main(String[] args) {
		System.out.println(Todo.sample());
	}
}
