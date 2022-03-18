package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class GetUserById {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entity = factory.createEntityManager();
		
		User user = entity.find(User.class, 1L);
		System.out.println("Dados retornados: " + user.getNome()
							+ ", " + user.getEmail());
		
		entity.close();
		factory.close();
	}
	
	

}
