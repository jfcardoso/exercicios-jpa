package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;


public class GetUsers {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entity = factory.createEntityManager();
		
		//criando a consulta - 1ª Opçao:		
		/*
		*String jpql= "select u from User u";
		*TypedQuery<User> query = entity.createQuery(jpql, User.class);
		*query.setMaxResults(6); //limitando o retorno da consulta		*
		*
		*List<User> users = query.getResultList();
		*/
		
		//2ª OPÇÃO:
		List<User> users = entity
				.createQuery("select u from User u", User.class)
				.setMaxResults(4)
				.getResultList();
		
		for(User u: users) {
			System.out.println(u.getNome());
		}
				
		entity.close();
		factory.close();
	}

}
