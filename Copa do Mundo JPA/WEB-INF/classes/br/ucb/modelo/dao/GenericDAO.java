package br.ucb.modelo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Class classe;
	private EntityManager em;

	@SuppressWarnings("rawtypes")
	public GenericDAO() {
		this.classe = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = ConnectionFactory.getEntityManager();
	}

	public int incluir(T objeto) {
		this.em.getTransaction().begin();
		this.em.persist(objeto);
		try {
			this.em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int excluir(T objeto) {
		this.em.getTransaction().begin();
		this.em.remove(objeto);
		try {
			this.em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int alterar(T objeto) {
		this.em.getTransaction().begin();
		this.em.merge(objeto);
		try {
			this.em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public T consultar(long id) {
		return (T) this.em.find(this.classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query q = this.em.createQuery("SELECT c FROM "+ this.classe.getName() +" c");
		return q.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

}