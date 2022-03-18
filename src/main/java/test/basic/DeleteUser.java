package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class DeleteUser {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entity = factory.createEntityManager();
		
		// Fazendo 1º uma busca no BD, para localizar o usuário pelo ID
		User user = entity.find(User.class, 1L);
		
		if (user != null) {
			entity.getTransaction().begin();					
			entity.remove(user); //excluindo o usuário			
			entity.getTransaction().commit();
		}	
		
		entity.close();
		factory.close();
	}

}
