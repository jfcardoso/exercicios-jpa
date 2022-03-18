package model.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double movieReview;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "movie_cast",
		//está relacionada a classe que estou agora:
		joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "id"),
		// é o que vem a partir da outra entidade (relação bidirecional)
		inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id")
	)
	private List<Actor> actors;

	public Movie() { }	

	public Movie(String name, Double movieReview) {		
		this.name = name;
		this.movieReview = movieReview;
	}
	
	public void addActor(Actor actor) {
		if(actor != null && !getActors().contains(actor)) {
			getActors().add(actor);
			if(!actor.getMovies().contains(this)) {
				actor.getMovies().add(this);
			}
		}
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMovieReview() {
		return movieReview;
	}

	public void setMovieReview(Double movieReview) {
		this.movieReview = movieReview;
	}

	public List<Actor> getActors() {
		if(actors == null) {
			actors = new ArrayList<>(); 
		}
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}		
	
	
}
