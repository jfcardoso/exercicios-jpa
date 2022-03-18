package Infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class DAO<E> { //classe genérica do tipo entidade
	

	private static EntityManagerFactory factory;
	private EntityManager entityManager; 
	Class<E> classe;
	
	static {
		try {
			factory = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// logar com log4j
		}
	}
	
	//construtor padrão
	public DAO() {
		this(null);
	}
	
	//construtor recebendo uma entidade como parâmetro
	public DAO(Class<E> classe) {
		this.classe = classe;
		entityManager = factory.createEntityManager();		
	}
	
	public DAO<E> openTransaction(){
		entityManager.getTransaction().begin();
		return this;		
	}
	
	public DAO<E> closeTransaction(){
		entityManager.getTransaction().commit();
		return this;		
	}
	
	public DAO<E> addEntity(E entity){
		entityManager.persist(entity);
		return this;
	}
	
	public DAO<E> addEntityWithTransaction(E entity){
		return this.openTransaction().addEntity(entity).closeTransaction();
	}
	
	public List<E> getAllEntitiesWithParams(int limit, int displacement){
		
		if (classe == null) {
			throw new UnsupportedOperationException("Entidade não pode ser nula!");
		}
		
		String jpql = "select u from " + classe.getName() + " u";
		TypedQuery<E> query = entityManager.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(displacement);
		return query.getResultList();
		
	}
	
	public E getEntityByID(Object id) {
		return entityManager.find(classe, id);		
	}
	
	public List<E> getAllEntities(){
		return this.getAllEntitiesWithParams(10, 0);
	}	
	
	// Object ... params -> var arg (argumentos variáveis)de objetos que irá
	// receber uma série de parâmetros (chaveXvalor) para a realização da consulta
	public List<E> queries(String queryName, Object... params){		
		TypedQuery<E> query = entityManager.createNamedQuery(queryName, classe);
		
		for (int i = 0; i < params.length; i+=2) {
			// array chave e valor (nome do filme e nota do filme)
			query.setParameter(params[i].toString(),params[i+1]);			
		}		
		
		return query.getResultList();		
	}
	
	public E queryOnE(String queryName, Object... params) {
		List<E> list = queries(queryName, params);		
		return list.isEmpty() ? null: list.get(0);		
	}
	
	public void close() {
		entityManager.close();
	}	
		
}
