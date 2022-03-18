package test.query;

import java.util.List;

import Infra.DAO;
import model.muitospramuitos.Actor;
import model.muitospramuitos.Movie;

public class GetMovie {
	
	public static void main(String[] args) {
		
		DAO<Movie> dao = new DAO<>(Movie.class);
		List<Movie> movies = dao.queries(
				"getMoviesNotesMoreThan", "movieReview", 9.0);
		
		for(Movie movie : movies) {
			System.out.println("Movie: " + movie.getName());
			
			for(Actor actor : movie.getActors()) {
				System.out.println("Cast: " + actor.getName());
			}
		}
		
	}

}
