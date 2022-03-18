package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class AlterUser {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entity = factory.createEntityManager();
		
		//Abrindo a transa��o por se tratar de uma altera��o na tabela
		entity.getTransaction().begin();
		
		// Fazendo 1� uma busca no BD, para localizar o usu�rio pelo ID
		User user = entity.find(User.class, 1L);
		//colocando o usu�rio no estado n�o gerenciado, assim qualquer altera��o
		// s� ser� atualizada no BD atrav�s do m�todo .merge()
		entity.detach(user);		
		//fazendo as altera��es
		user.setNome("Dom Pedro II");
		user.setEmail("dom_pedro@gov.br");
		//subindo as altera��es para o banco
		entity.merge(user);
		
		entity.getTransaction().commit();
		
		entity.close();
		factory.close();
	}

}
