package test.query;

import Infra.DAO;
import model.query.MovieNote;

public class GetMoviesAverage {
	
	public static void main(String[] args) {
		
		DAO<MovieNote> dao = new DAO<>(MovieNote.class);
		MovieNote movieNote = dao.queryOnE("getOverallMoviesAverage");
		
		System.out.printf("Média Geral: %.1f", movieNote.getAverage());	
		
		dao.close();		
	}

}
