package br.com.carpal.repository.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

/** Autor: Dowglas Maia - Skype: live:dowglasmaia */
/** Class DAO Gerenico */

public abstract class AbstractRepository<T, PK extends Serializable> {

	// Metodo auxilar para Consultas Genericas, Recuperando a Class de Instancia
	@SuppressWarnings("unchecked")
	private final Class<T> entidadeClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	/* Instanciando um EntityManager */
	@PersistenceContext
	protected EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	/* salvar */
	@Transactional(rollbackFor = { Exception.class })
	public T save(T obj) {
		manager.persist(obj);
		return obj;
	}

	/* Atualizar */
	@Transactional(rollbackFor = { Exception.class })
	public T update(T obj) {
		manager.merge(obj);
		return obj;
	}

	/* Deletar */
	@Transactional(rollbackFor = { Exception.class })
	public void delete(PK id) {
		manager.remove(manager.getReference(entidadeClass, id));
	}

	/* Buscar por ID */
	public T findById(PK id) {
		return manager.find(entidadeClass, id);
	}

	/* Buscar Todos */
	public List<T> findAll() {
		return manager.createQuery("from " + entidadeClass.getSimpleName(), entidadeClass).getResultList();
	}

	/* Consultar Dinamica */
	protected List<T> createDinamicQuery(String jpql, Object... params) {
		TypedQuery<T> query = manager.createQuery(jpql, entidadeClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}
}
