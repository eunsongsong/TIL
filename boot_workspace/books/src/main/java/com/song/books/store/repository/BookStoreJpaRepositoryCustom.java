package com.song.books.store.repository;

import java.util.List;

public interface BookStoreJpaRepositoryCustom {
	List<BookJpo> findByQuery(String nativeQuery);

}
