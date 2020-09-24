package com.song.mc.todos.store.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class TodoStoreJpaRepositoryImpl implements TodoStoreJpaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<TodoJpo> findByQuery(String nativeQuery) {
		return entityManager.createNativeQuery(nativeQuery, TodoJpo.class).getResultList();
	}

}
