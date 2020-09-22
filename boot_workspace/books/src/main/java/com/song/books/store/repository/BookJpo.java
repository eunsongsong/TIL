package com.song.books.store.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.song.books.domain.Book;

import lombok.Data;

@Entity
@Data
@Table(name="books")
public class BookJpo {
	
	@Id
	@Column(nullable=false, unique=true)
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String imgUrl;
	private String introduce;
	
	public BookJpo(Book book) {
		super();
		BeanUtils.copyProperties(book, this); // book을 현재 객체에 copy
	}
	
	public Book toDomain() {
		Book book = new Book();
		BeanUtils.copyProperties(this, book); // 현재 객체를 book에 copy
		return book;
	}

	public static List<Book> toDomains(List<BookJpo> bookJpos){
		return bookJpos.stream().map(BookJpo::toDomain).collect(Collectors.toList());
	}
}




