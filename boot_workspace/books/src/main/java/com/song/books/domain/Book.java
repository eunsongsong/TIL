package com.song.books.domain;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String imgUrl;
	private String introduce;

	@Override
	public String toString() {
		Gson json = new Gson();
		return json.toJson(this); // 현재 객체의 데이터를 제이슨 형태로 리턴
	}

	public static Book sample() {
		return new Book("9781617293986", "Spring Microservices in Action", "John Carnell", "Manning", 59.92,
				"book_images/spring.jpg", "Spring Boot and Spring Cloud offer Java developers an easy");
	}

	public static void main(String[] args) {
		System.out.println(Book.sample());
	}
}
