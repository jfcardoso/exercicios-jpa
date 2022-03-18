package model.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Nephew {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "nephews")
	private List<Uncle> uncles = new ArrayList<>();		
	
	public Nephew() {	}	
	
	public Nephew(String nome) {		
		this.nome = nome;
	}

	public List<Uncle> getUncles() {
		return uncles;
	}

	public void setUncles(List<Uncle> uncles) {
		this.uncles = uncles;
	}	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
