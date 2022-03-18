package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class NewUser {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entity = factory.createEntityManager();
	
		User user = new User("Aparecida Santos", "cida@gmail.com.br");
		
		//abrindo uma transação
		entity.getTransaction().begin();	
		//para persistir (inserir) dados no DB
		entity.persist(user);
		//dando o commit para concretizar a inserção
		entity.getTransaction().commit();
	
		entity.close();
		factory.close();
		
	}
}
