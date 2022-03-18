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
		
		//Abrindo a transação por se tratar de uma alteração na tabela
		entity.getTransaction().begin();
		
		// Fazendo 1º uma busca no BD, para localizar o usuário pelo ID
		User user = entity.find(User.class, 1L);
		//colocando o usuário no estado não gerenciado, assim qualquer alteração
		// só será atualizada no BD através do método .merge()
		entity.detach(user);		
		//fazendo as alterações
		user.setNome("Dom Pedro II");
		user.setEmail("dom_pedro@gov.br");
		//subindo as alterações para o banco
		entity.merge(user);
		
		entity.getTransaction().commit();
		
		entity.close();
		factory.close();
	}

}
