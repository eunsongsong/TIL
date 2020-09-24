package com.song.books.store.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BookStoreJpaRepositoryImpl implements BookStoreJpaRepositoryCustom {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BookJpo> findByQuery(String nativeQuery) {
		return entityManager.createNativeQuery(nativeQuery, BookJpo.class).getResultList();
	}

}
