package com.song.books.domain.service.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.books.domain.Book;
import com.song.books.domain.service.BookService;
import com.song.books.store.BookStore;
import com.song.books.store.exception.DuplicateException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookStore bookStore;
	
	@Override
	public List<Book> bookList() throws NoSuchElementException{
		List<Book> books = bookStore.retrieveAll();
		return books;
	}

	@Override
	public Book bookDetail(String ISBN) throws NoSuchElementException{
		return bookStore.retrieve(ISBN);
	}

	@Override
	public void bookCreate(Book book) throws DuplicateException{
		bookStore.create(book);
	}

	@Override
	public void bookModify(Book book) throws NoSuchElementException{
		bookStore.update(book);
	}

	@Override
	public void bookDelete(String ISBN) throws NoSuchElementException{
		bookStore.delete(ISBN);
	}

	@Override
	public List<Book> search(String keyword, String searchType) throws NoSuchElementException{
		return bookStore.search(keyword, searchType);
	}

}
