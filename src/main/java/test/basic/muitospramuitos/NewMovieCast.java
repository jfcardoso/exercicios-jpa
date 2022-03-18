package test.basic.muitospramuitos;

import Infra.DAO;
import model.muitospramuitos.Actor;
import model.muitospramuitos.Movie;

public class NewMovieCast {
	
	public static void main(String[] args) {
		
		Movie movie1 = new Movie("Central do Brasil", 8.9);
		Movie movie2 = new Movie("O Auto da Compadecida", 9.3);
		
		Actor actress1 = new Actor("Fernanda MonteNegro");
		Actor actor1 = new Actor("Caio Junqueira");
		Actor actor2 = new Actor("Selton Mello");
		
		movie1.addActor(actress1);
		movie1.addActor(actor1);
		movie2.addActor(actress1);
		movie2.addActor(actor2);
		
		DAO<Movie> dao = new DAO<>();
		dao.addEntityWithTransaction(movie1);
		
		
		
	}
	


}
