package br.com.carpal.repository.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/** Autor: Dowglas Maia - Skype: live:dowglasmaia */
/** Class DAO Gerenico */

public abstract class AbstractRepository<T, PK extends Serializable> {

	/* == Auxilar nas Consultas Generica, Recuperando a Class de Instacia == */
	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	// Salvar
	public void save(T entity) {
		entityManager.persist(entity);
	}

	// Atualizar
	public void update(T entity) {
		entityManager.merge(entity);
	}

	// Deletar
	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	// Buscar Por Id
	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}

	// Buscar Todos
	public List<T> findAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}

	// consulta dinamica
	protected List<T> createQuery(String jpql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}

}
